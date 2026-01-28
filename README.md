## FpML as Rune

This repository is a [Rune DSL](https://github.com/finos/rune-dsl) model that contains Rune representation of the FpML 5.13 schema, Confirmation view. The model was created by the importing the FpML schema .xsd files, which translates each FpML schema complex type into an equivalent Rune data type, e.g., FpML `<dataDocument>` is imported into the Rune model as type `DataDocument`.

What is Rune?

- Rune is a Domain-Specific Language (DSL) that supports the modelling of operational processes for the financial markets' industry.
- Its purpose is to promote consistency and inter-operability between the various implementations of these processes.

What is FpML?

- FpML (Financial products Markup Language) is an open-source XML standard used for the electronic dealing and processing of derivatives transactions.
- It provides a protocol for sharing information and conducting business for over-the-counter (OTC) derivatives and structured products.
- Essentially, it facilitates the electronic exchange of information related to derivatives transactions, including swaps, options, and other structured products.

<br>

## ✍️ What FpML looks like in Rune

FpML can be parsed in Rune or by an xsd schema 

Commodity products in an FpML sample follow this syntax

```xml
     <commodity>
        <instrumentId instrumentIdScheme="http://www.fpml.org/coding-scheme/commodity-reference-price-1-0">HEATING OIL - NEW YORK - NYMEX</instrumentId>
        <commodityBase>Heating Oil</commodityBase>
        <commodityDetails>XXX</commodityDetails>
        <unit>GAL</unit>
        <currency>USD</currency>
        <exchangeId>EXCHANGEID</exchangeId>
        <specifiedPrice>Settlement</specifiedPrice>
        <deliveryDates>FirstNearby</deliveryDates>
        <deliveryDateRollConvention>
          <periodMultiplier>1</periodMultiplier>
          <period>M</period>
          <dayType>CommodityBusiness</dayType>
        </deliveryDateRollConvention>
      </commodity>
```

Parsed in XSD

```xml
<xsd:group name="CommodityProduct.model">
  <xsd:sequence>
    <xsd:group ref="CommodityReferencePriceFramework.model" minOccurs="0"></xsd:group>
    <xsd:element name="specifiedPrice" type="SpecifiedPriceEnum">
    </xsd:element>
    <xsd:sequence minOccurs="0">
      <xsd:choice>
        <xsd:choice>
          <xsd:element name="deliveryDates" type="DeliveryDatesEnum" fpml-annotation:deprecated="true" fpml-annotation:deprecatedReason="Enumerated representation of deliveryDates is deprecate in favor of a parametric representation. Rationale: There is a need to track all the possible nearby contracts used for pricing. The 'DeliveryDatesEnum' list can grow significantly. Use instead 'deliveryNearby' component that contain a deliveryNearbyMultiplier (e.g. 0, 1, 2, 3, ...) and a deliveryNearbyType (e.g. NearByMonth, NearByWeek, etc.)."></xsd:element>
          <xsd:element name="deliveryNearby" type="DeliveryNearby"></xsd:element>
        </xsd:choice>
        <xsd:element name="deliveryDate" type="AdjustableDate"></xsd:element>
        <xsd:element name="deliveryDateYearMonth" type="xsd:gYearMonth"></xsd:element>
      </xsd:choice>
      <xsd:element name="deliveryDateRollConvention" type="Offset" minOccurs="0"></xsd:element>
      <xsd:element name="deliveryDateExpirationConvention" type="Offset" minOccurs="0"></xsd:element>
    </xsd:sequence>
    <xsd:element name="multiplier" type="PositiveDecimal" minOccurs="0"></xsd:element>
  </xsd:sequence>
</xsd:group>
```

Parsed in Rune

```xml
type Commodity extends IdentifiedAsset: <"Identifies the underlying asset when it is a listed commodity. A type describing a commodity underlying asset.">
    commodityProductModel CommodityProductModel (1..1)
    
    
type CommodityProductModel: <"A group used to specify details of a commodity underlyer.">
    commodityReferencePriceFrameworkModel CommodityReferencePriceFrameworkModel (0..1)
    specifiedPrice SpecifiedPriceEnum (1..1) <"The \'specified Price\' describes the nature of the underlying price that is observed. It must be be stated in the underlyer definition as it is not defined in the Commodity Reference Price. Example values of \'specifiedPrice\' are \'Settlement\' (for a futures contract) and \'WeightedAverage\' (for some published prices and indices).">
    commodityProductModelSequence CommodityProductModelSequence (0..1)
    multiplier PositiveDecimal (0..1) <"The \'multiplier\' specifies the multiplier associated with the Transaction. The \'multiplier\' element has two uses: (1) for Freight Transactions or any Calculation Period specified for a Freight Transaction, if an amount is specified as the Multiplier then it is captured by this element and (2) if the Transaction is a heat rate option, the heat rate multiplier is represented in this element. If multiplier is not provided, multiplier is assumed to be 1. (i.e. rate source states 1 BBL of Oil as 90 Dollars. Multiplier of 10 will change the value to 900 dollars.)">
```

Graphical Representation of Rune in Rosetta

<img width="1002" height="511" alt="image" src="https://github.com/user-attachments/assets/b419ba15-f476-489d-b009-9600b0344f6c" />

## ⚔️ Supported Product Types in Rune

For a full list of support products, see the **supported types in Rune** in Appendix 1

<br>


## 🔑 Root Types & Top-Level Elements

### Root Types

The `rootType` annotation marks a type as a root of the rune model.

For a full list of root types see the **root types** in Appendix 2.

<br>

### Base Types

_Document_

The `Document` type is the abstract base type from which all FpML compliant messages and documents must be derived.

Types `Message` and `DataDocument` extend `Document`

- `Message` - A type defining the basic structure of all FpML messages which is refined by its derived types.
- `DataDocument` - A document containing trade and/or portfolio and/or party data without expressing any processing intention. A type defining a content model that is backwards compatible with older FpML releases and which can be used to contain sets of data without expressing any processing intention


_Product_ 

The `Product` type acts as the base type which all FpML products extend. Within `Product` , the `identifier` and `productModel` can be defined.

Using `procuctModel` , all products can specify:

- primaryAssetClass
- secondaryAssetClass
- productType
- productId
- assetClass

<br>

_Rate_

`Rate` acts as the abstract base class for all types which define interest rate streams

<br>

_Leg_

`Leg` is a supertype. All swap legs extend this type.

<br>

_Exercise_

`Exercise` is the abstract base class for all types which define way in which options may be exercised.

<br>

_Asset_

`Asset` is the abstract base class for all underlying assets.

<br>


## **📚 Further Reading**

- Learn more about how Rune DSL maps FpML into Rune model in the [documentation](https://docs.rosetta-technology.io/rosetta/rune-dsl/).
- View the full list of FpML coding schemas [here.](https://www.fpml.org/spec/coding-scheme/index.html)
- View the full list of supported products in the FpML product summary [here.](https://www.fpml.org/about/product-summary/)

<br>

## **🔧 Getting Started**

### Maven Dependency

```
<dependency>
  <groupId>com.regnosys.rune-fpml</groupId>
  <artifactId>rosetta-source</artifactId>
  <version>0.16.1</version>
</dependency>
```

### FpML Schemas

With FpML 5-6 , FpML has been divided into several very closely related schemas to better support different types of business processes. Each of these schemas, called a "view", has a distinct namespace and element and type definitions. However, each view is built from the same source schema, and so shares a number of features, such as element names.

Supported views/schemas in FpML as Rune include:

1. Confirmation - This view is intended to be used for confirming the precise details of contracts and post-trade business events.

2. Transparency - This view is intended to be used for reporting price forming information about executed transactions to the public by reporting parties and execution platforms.

3. Record Keeping - This view is intended to be used for reporting the Primary Economic Terms of derivative transactions to Swaps Data Repositories from entities including market participants, execution platforms, and clearing or confirmation services. 

For more information on FpML views, see the FpML overview [here](https://www.fpml.org/spec/fpml-5-6-5-rec-1/html/confirmation/fpml-5-6-intro-2.html).

Supported FpML Schemas

Currently the model is based on FpML Confirmation 5.13. FpML Confirmation is backwards compatible, so actually is supports all FpML 5.x versions

| Version | Confirmation | Record Keeping |
| --- | --- | --- |
| 5.13 | x | Roadmap |
| 5.12 | x | Roadmap |
| 5.11 | x | Roadmap |
| 5.10 | x | Roadmap |
| 5.10a | x | Roadmap |
| 5.9 | x | Roadmap |
| 5.8 | x | Roadmap |
| 5.7 | x | Roadmap |
| 5.6 | x | Roadmap |
| 5.5 | x | Roadmap |
| 5.4 | x | Roadmap |
| 5.3 | x | Roadmap |
| 5.2 | x | Roadmap |
| 5.1 | x | Roadmap |

<br>

### 🎗️ Supported FpML as Rune Versions

https://github.com/rosetta-models/rune-fpml/releases

<br>

### Serialization

<br>


## **📄 License**

[Apache License 2.0](https://apache.org/licenses/LICENSE-2.0)

### **Exhibit A**

- The FpML Specifications of this document are subject to the FpML Public License (the “License”); you may not use the FpML Specifications except in compliance with the License. You may obtain a copy of the License at [http://www.FpML.org](http://www.fpml.org/).
- The FpML Specifications distributed under the License are distributed on an “AS IS” basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific language governing rights and limitations under the License.
- The Licensor of the FpML Specifications is the International Swaps and Derivatives Association, Inc. All Rights Reserved.

<br>

___________________________________________________________________________

## Appendix

### Appendix 1: Supported Types in Rune

| Documents | Products | Rate | Leg | Exercise | Asset |
| --- | --- | --- | --- | --- | --- |
| LoanNotificationAcknowledgement | Swaption | StubFloatingRate | RepoNearLeg | EuropeanExercise | Cash |
| LoanNotificationException | FxVolatilitySwap | LoanFloatingRate | RepoFarLeg | CommodityPhysicalAmericanExercise | TermLoan |
| ExecutionAdviceException | FxVarianceSwap | FloatingRateCalculation | ReturnLeg | CommodityAmericanExercise | DelayedDraw |
| ClearingException | Swap | InflationRateCalculation | InterestLeg | FxAmericanExercise | Revolver |
| VerificationStatusException | VolatilitySwapTransactionSupplement |  | FixedPaymentLeg | FxDigitalAmericanExercise | LetterOfCreditFacility |
| ConfirmationException | FxFlexibleForward |  | UnderlyerInterestLeg | AmericanExercise | Deal |
| CreditEventException | DividendSwapTransactionSupplement |  | DividendLeg | BermudaExercise | SimpleIRSwap |
| TradeReferenceInformationUpdateException | FxAccrualForward |  | VolatilityLeg | EquityEuropeanExercise | MutualFund |
| EventStatusException | GenericProduct |  | CorrelationLeg | CommodityPhysicalEuropeanExercise | RateIndex |
| ServiceNotificationException | InstrumentTradeDetails |  | VarianceLeg | FxEuropeanExercise | Deposit |
| CollateralAllocationRejected | EquityOptionTransactionSupplement |  | FeeLeg | CommodityEuropeanExercise | Fx |
| ClearingEligibilityException | BrokerEquityOption |  | FxSwapLeg | EquityBermudaExercise | Loan |
| MessageRejected | EquityForward |  | InterestRateStream | EquityAmericanExercise | ConvertibleBond |
| ExecutionException | EquityOption |  | AveragePriceLeg |  | Bond |
| AllocationException | StandardProduct |  | FixedLeg |  | SimpleFra |
| MaturityException | Fra |  | WeatherLeg |  | OptionElement |
| TradeChangeAdviceException | FxAccrualOption |  | FloatingLeg |  | Warrant |
| ConsentException | BondOption |  | NonPeriodicFixedPriceLeg |  | ExchangeTradedContract |
| LoanAllocationNotification | CreditDefaultSwapOption |  | MetalPhysicalLeg |  | Index |
| RequestAllocation | DividendSwapOptionTransactionSupplement |  | BullionPhysicalLeg |  | ExchangeTradedFund |
| ExecutionAdvice | VarianceOptionTransactionSupplement |  | GasPhysicalLeg |  | Equity |
| RequestClearingEligibility | FxDigitalOption |  | OilPhysicalLeg |  | Future |
| RequestConfirmation | FxOption |  | ElectricityPhysicalLeg |  | Mortgage |
| RequestCollateralAllocation | FxAccrualDigitalOption |  | EnvironmentalPhysicalLeg |  | SimpleCreditDefaultSwap |
| RequestConsent | CommodityBasketOption |  | CoalPhysicalLeg |  | Commodity |
| LoanPartyProfileStatement | CommodityDigitalOption |  | CommodityVarianceLeg |  | Security |
| RequestTradeReferenceInformationUpdate | VarianceSwapTransactionSupplement |  | CommodityInterestLeg |  | Basket |
| CreditEventNotification | CommoditySwaption |  | #N/A |  |  |
| RequestExecution | FxForwardVolatilityAgreement |  |  |  |  |
| OptionExpirationNotification | CorrelationSwap |  |  |  |  |
| ExecutionNotification | VolatilitySwap |  |  |  |  |
| TradeChangeAdvice | VarianceSwap |  |  |  |  |
| MaturityNotification | Strategy |  |  |  |  |
| LoanContractNotification | CommodityForward |  |  |  |  |
| LcNotification | CommoditySwap |  |  |  |  |
| LoanBulkServicingNotification | CreditDefaultSwap |  |  |  |  |
| LoanLegalActionNotification | TermDeposit |  |  |  |  |
| FacilityNotification | CapFloor |  |  |  |  |
| LoanCovenantObligationNotification | FxRangeAccrual |  |  |  |  |
| LoanTradeNotification | CommodityOption |  |  |  |  |
| DealStatement | Repo |  |  |  |  |
| FacilityStatement | CommodityPerformanceSwap |  |  |  |  |
| OutstandingContractsStatement | FxSingleLeg |  |  |  |  |
| FacilityPositionStatement | FxTargetKnockoutForward |  |  |  |  |
| LoanLegalActionStatement | FxSwap |  |  |  |  |
| RequestClearing | SecurityLending |  |  |  |  |
| RequestRetransmission | BulletPayment |  |  |  |  |
| RequestConfirmationRetracted | EquitySwapTransactionSupplement |  |  |  |  |
| RequestConsentRetracted | ReturnSwap |  |  |  |  |
| RequestEventStatus |  |  |  |  |  |
| TradeChangeAdviceRetracted |  |  |  |  |  |
| CreditEventNotificationRetracted |  |  |  |  |  |
| RequestClearingRetracted |  |  |  |  |  |
| RequestExecutionRetracted |  |  |  |  |  |
| VerificationStatusNotification |  |  |  |  |  |
| ExecutionRetracted |  |  |  |  |  |
| LoanNotificationRetracted |  |  |  |  |  |
| RequestAllocationRetracted |  |  |  |  |  |
| RequestTradeReferenceInformationUpdateRetracted |  |  |  |  |  |
| ExecutionAdviceRetracted |  |  |  |  |  |
| CollateralAllocationAcknowledgement |  |  |  |  |  |
| CreditEventAcknowledgement |  |  |  |  |  |
| VerificationStatusAcknowledgement |  |  |  |  |  |
| ClearingEligibilityAcknowledgement |  |  |  |  |  |
| AllocationRefused |  |  |  |  |  |
| ConfirmationDisputed |  |  |  |  |  |
| ConsentRefused |  |  |  |  |  |
| ConfirmationStatus |  |  |  |  |  |
| AllocationApproved |  |  |  |  |  |
| ClearingEligibility |  |  |  |  |  |
| MaturityAcknowledgement |  |  |  |  |  |
| ExecutionAdviceAcknowledgement |  |  |  |  |  |
| ConfirmationAcknowledgement |  |  |  |  |  |
| ClearingAcknowledgement |  |  |  |  |  |
| ConsentAcknowledgement |  |  |  |  |  |
| TradeReferenceInformationUpdateAcknowledgement |  |  |  |  |  |
| AllocationAcknowledgement |  |  |  |  |  |
| TradeChangeAdviceAcknowledgement |  |  |  |  |  |
| ExecutionAcknowledgement |  |  |  |  |  |
| ConfirmationAgreed |  |  |  |  |  |
| CollateralAllocationAccepted |  |  |  |  |  |
| EventStatusResponse |  |  |  |  |  |
| ConsentGranted |  |  |  |  |  |
| ClearingConfirmed |  |  |  |  |  |
| ClearingStatus |  |  |  |  |  |
| ServiceNotification |  |  |  |  |  |
| ClearingRefused |  |  |  |  |  |
| ApprovalStatusNotification |  |  |  |  |  |
| ValuationDocument |  |  |  |  |  |
| DataDocument |  |  |  |  |  |

### Appendix 2: Root Types

| Root Types |
| --- |
| DataDocument |
| ValuationDocument |
| RequestClearingEligibility |
| ClearingEligibility |
| ClearingEligibilityException |
| ClearingEligibilityAcknowledgement |
| RequestExecution |
| RequestExecutionRetracted |
| ExecutionNotification |
| ExecutionRetracted |
| ExecutionAcknowledgement |
| ExecutionException |
| ExecutionAdvice |
| ExecutionAdviceRetracted |
| ExecutionAdviceAcknowledgement |
| ExecutionAdviceException |
| MaturityNotification |
| MaturityAcknowledgement |
| MaturityException |
| RequestTradeReferenceInformationUpdate |
| RequestTradeReferenceInformationUpdateRetracted |
| TradeReferenceInformationUpdateAcknowledgement |
| TradeReferenceInformationUpdateException |
| TradeChangeAdvice |
| TradeChangeAdviceRetracted |
| TradeChangeAdviceAcknowledgement |
| TradeChangeAdviceException |
| RequestConsent |
| RequestConsentRetracted |
| ConsentAcknowledgement |
| ConsentException |
| ConsentGranted |
| ConsentRefused |
| ApprovalStatusNotification |
| RequestConfirmation |
| RequestConfirmationRetracted |
| ConfirmationAcknowledgement |
| ConfirmationException |
| ConfirmationStatus |
| ConfirmationAgreed |
| ConfirmationDisputed |
| RequestClearing |
| RequestClearingRetracted |
| ClearingAcknowledgement |
| ClearingException |
| ClearingRefused |
| ClearingStatus |
| ClearingConfirmed |
| RequestAllocation |
| RequestAllocationRetracted |
| AllocationAcknowledgement |
| AllocationException |
| AllocationRefused |
| AllocationApproved |
| RequestCollateralAllocation |
| CollateralAllocationAcknowledgement |
| CollateralAllocationRejected |
| CollateralAllocationAccepted |
| OptionExpirationNotification |
| CreditEventNotice |
| CreditEventNotification |
| CreditEventNotificationRetracted |
| CreditEventAcknowledgement |
| CreditEventException |
| ValuationSet: |
| LoanBulkServicingNotification |
| LoanNotificationAcknowledgement |
| LoanNotificationException |
| LoanNotificationRetracted |
| LoanPartyProfileStatement |
| LoanCovenantObligationNotification |
| FacilityNotification |
| LcNotification |
| LoanContractNotification |
| LoanLegalActionNotification |
| LoanAllocationNotification |
| LoanTradeNotification |
| DealStatement |
| FacilityStatement |
| FacilityPositionStatement |
| LoanLegalActionStatement |
| OutstandingContractsStatement |
| EventStatusResponse |
| EventStatusException |
| MessageRejected |
| ServiceNotification |
| ServiceNotificationException |
| RequestEventStatus |
| RequestRetransmission |
| VerificationStatusNotification |
| VerificationStatusException |
| VerificationStatusAcknowledgement |
| BasketChange |
| ChangeEvent |
| CreditChangeEvent |
| CorporateAction |
| IndexChange |
| Signature |
| SignatureValue |
| SignedInfo |
| CanonicalizationMethod |
| SignatureMethod |
| ReferenceElement |
| Transforms |
| Transform |
| DigestMethod |
| DigestValue: |
| KeyInfo |
| KeyName: |
| MgmtData: |
| KeyValue |
| RetrievalMethod |
| X509Data |
| PGPData |
| SPKIData |
| _Object |
| Manifest |
| SignatureProperties |
| SignatureProperty |
| DSAKeyValue |
| RSAKeyValue |
| Market |

## How to release a new version of the Rune-FpML Project

1. Go to the [releases](https://github.com/rosetta-models/rune-fpml/releases) page.
2. Click on `Draft a new release`.
3. Make sure the target branch is `master`.
4. In the `Select Tag` box, the latest version will be the top.
5. Increment that [semantic version](https://semver.org/spec/v2.0.0.html) and enter in the `Select Tag` box and click `Create new tag`.
6. Click on `Generate release notes`. This will generate the title and changelog based on the commits since the last release.
7. The generated release notes will have links to the Pull Requests that were merged since the last release.
8. For each PR generated by Rosetta, there will be a release note as a comment of the PR. Replace each PR link with PR Release Notes.
9. Click Publish release.
10. The release will trigger a build in the CI/CD pipeline.
11. The build will publish the new version of the Rune-FpML Project to the Artifact Registry.
12. The release will also trigger a notification email to the project maintainers.