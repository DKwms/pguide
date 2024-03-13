@echo on
@echo =============================================================
@echo $                                                           $
@echo $           PGuide Microservices-Platform                   $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $  PGuide All Right Reserved                                $
@echo $  Copyright (C) 2023-2025                                  $
@echo $  @author StevenZhang                                      $
@echo =============================================================
@echo.
@echo off

@title PGuide Microservices-Platform
@color 0e

call mvn clean -Dmaven.test.skip=true

pause