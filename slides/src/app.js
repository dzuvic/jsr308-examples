(function() {
  'use strict';

  /* @ngInject */
  function configureSlides(slidesConfig) {
    slidesConfig.slides = [
      'title',
      'overview',
      
      'intro/about-me',
      'intro/about-us',
      
      'jsr308/motivation/title',
      'jsr308/motivation/fails',
      'jsr308/motivation/proofs',
      'jsr308/motivation/jsr308-goals',
      'jsr308/motivation/java-type-system',

      'jsr308/annotation/title',
      'jsr308/annotation/annotations',
      'jsr308/annotation/type-annotations',
      'jsr308/annotation/type-annotations-risk',
      'jsr308/annotation/type-syntax',
      'jsr308/annotation/type-syntax-invalid',
      'jsr308/annotation/type-syntax-example1',

      'jsr308/checker/framework/title',
      'jsr308/checker/framework/checker-intro',
      'jsr308/checker/framework/checker-unit',
      'jsr308/checker/framework/checker-stringformat',
      'jsr308/checker/framework/checker-regex',
      'jsr308/checker/framework/checker-regex-hierarchy',
      'jsr308/checker/framework/checker-nonnull',
      'jsr308/checker/framework/checker-nonnull-hierarchy',
      'jsr308/checker/framework/checker-nonnull-simple',
      'jsr308/checker/framework/checker-nonnull-ensure-not-null',
      'jsr308/checker/framework/checker-nonnull-advanced',
      'jsr308/checker/framework/checker-interning',
      'jsr308/checker/framework/checker-tainting',
      'jsr308/checker/framework/checker-own-subtype',
      'jsr308/checker/framework/checker-own-checker',
      'jsr308/checker/framework/checker-list',
      'jsr308/checker/integration/title',
      'jsr308/checker/integration/ci-options',
      'jsr308/checker/integration/ci-classpath',
      'jsr308/checker/integration/ci-intellij',


      'jsr308/fazit/title',
      'jsr308/fazit/issues',
      'jsr308/fazit/benefit',
      'jsr308/fazit/imho',
      'jsr308/fazit/tipps',
      'jsr308/fazit/references',
      'jsr308/fazit/thanx',

      
      
      'end'
    ];

    slidesConfig.slideTemplatePrefix= '@@cacheBustingDir/slides/';
    slidesConfig.slideTemplateSuffix = '.html';

    slidesConfig.masters = {
      'regular': '@@cacheBustingDir/masters/regular.html',
      'section-title': '@@cacheBustingDir/masters/section-title.html',
      'expert': '@@cacheBustingDir/masters/expert.html',
      'hands-on': '@@cacheBustingDir/masters/hands-on.html',
      'demo': '@@cacheBustingDir/masters/demo.html'
    };
  }

  var module = angular.module('app', [
    'app.templates',
    'w11k.slides',
    'w11k.slides.template',
    'ngSanitize'
  ]);

  // set presentation mode on startup
  module.run(function (SlidesService) {
   SlidesService.setMode('screen');
  });

  module.config (configureSlides);
}());
