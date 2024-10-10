package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.Algorithm;
import fpml.confirmation.AllocationReportingStatus;
import fpml.confirmation.ClearingStatusValue;
import fpml.confirmation.CollateralizationType;
import fpml.confirmation.ConfirmationMethod;
import fpml.confirmation.EndUserExceptionDeclaration;
import fpml.confirmation.ExecutionDateTime;
import fpml.confirmation.ExecutionType;
import fpml.confirmation.ExecutionVenueType;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.PartyTradeInformation;
import fpml.confirmation.PartyTradeInformation.PartyTradeInformationBuilder;
import fpml.confirmation.PartyTradeInformation.PartyTradeInformationBuilderImpl;
import fpml.confirmation.PartyTradeInformation.PartyTradeInformationImpl;
import fpml.confirmation.PartyTradeInformationSequence;
import fpml.confirmation.PortfolioName;
import fpml.confirmation.PricingContext;
import fpml.confirmation.RelatedBusinessUnit;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.RelatedPerson;
import fpml.confirmation.ReportingRegime;
import fpml.confirmation.ReportingRole;
import fpml.confirmation.TradeCategory;
import fpml.confirmation.TradeProcessingTimestamps;
import fpml.confirmation.Trader;
import fpml.confirmation.TransactionClassificationModel;
import fpml.confirmation.Unit;
import fpml.confirmation.VerificationMethod;
import fpml.confirmation.meta.PartyTradeInformationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining party-specific additional information that may be recorded against a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyTradeInformation", builder=PartyTradeInformation.PartyTradeInformationBuilderImpl.class, version="${project.version}")
public interface PartyTradeInformation extends RosettaModelObject {

	PartyTradeInformationMeta metaData = new PartyTradeInformationMeta();

	/*********************** Getter Methods  ***********************/
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	/**
	 * This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the &quot;partyReference&quot; in the partyTradeInformation block.
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 * Identifies the role of this party in reporting this trade (e.g. originator, counterparty).
	 */
	ReportingRole getReportingRole();
	/**
	 * Identifies the unit/division/desk etc. that executed or supports this trade
	 */
	List<? extends Unit> getUnit();
	/**
	 * Provides information about a unit/division/desk etc. that executed or supports this trade
	 */
	List<? extends RelatedBusinessUnit> getRelatedBusinessUnit();
	/**
	 * Provides information about a person that executed or supports this trade
	 */
	List<? extends RelatedPerson> getRelatedPerson();
	/**
	 * Provides information about an algorithm that executed or otherwise participated in this trade this trade
	 */
	List<? extends Algorithm> getAlgorithm();
	/**
	 * Specifies whether the trade used to hedge a risk for accounting purposes for the specified party. (TODO: do we need to distinguish between asset and liability hedges?)
	 */
	Boolean getIsAccountingHedge();
	/**
	 * Used to categorize trades into user-defined categories, such as house trades vs. customer trades.
	 */
	List<? extends TradeCategory> getCategory();
	/**
	 * Identifies the person or persons who assumed the role of trader for this trade. New implementations are encouraged to use the relatedPerson structure instead.
	 */
	List<? extends Trader> getTrader();
	/**
	 * Trade execution date time, for example as provided by a central execution facility. Normally this refers to the original execution time of the trade, not the execution time of any post-trade events that may have affeted it. However, in the case of a post trade event that reports the new version of the trade (for example, the novation trade in an novation event, or the amended trade in an amendment event), the execution date time may contain the time that the newly created or modified trade was created or modified.
	 */
	ExecutionDateTime getExecutionDateTime();
	/**
	 * Allows timing information about a trade to be recorded.
	 */
	TradeProcessingTimestamps getTimestamps();
	/**
	 * Specifies whether the trade is anticipated to be allocated.
	 */
	Boolean getIntentToAllocate();
	/**
	 * Specifies whether the trade is anticipated to be allocated, has been allocated, or will not be allocated.
	 */
	AllocationReportingStatus getAllocationStatus();
	/**
	 * Specifies whether the trade is anticipated to be cleared via a derivative clearing organization
	 */
	Boolean getIntentToClear();
	/**
	 * Describes the status with respect to clearing (e.g. AwaitingAcceptance, Pending, Accepted, Rejected, etc.)
	 */
	ClearingStatusValue getClearingStatus();
	/**
	 * Specifies whether this party posts collateral. For Recordkeeping, the collateralization type refers to collateral that is posted by this firm, and One-Way is not meaningful. In other words, if the collateralization type is Full, this trade is fully collateralized by this party. For Transparency view, the options include Full, Partial, Uncollateralized, and One-Way.
	 */
	CollateralizationType getCollateralizationType();
	/**
	 * Provides a name, code, or other identifier for the collateral portfolio to which this belongs.
	 */
	PortfolioName getCollateralPortfolio();
	/**
	 * Allows the organization to specify which if any relevant regulators or other supervisory bodies this is relevant for, and what reporting rules apply.
	 */
	List<? extends ReportingRegime> getReportingRegime();
	PartyTradeInformationSequence getPartyTradeInformationSequence();
	/**
	 * Claims an end user exception and provides supporting evidence. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 */
	EndUserExceptionDeclaration getEndUserExceptionDeclaration();
	/**
	 * Indicates that the trade has price-affecting characteristics in addition to the standard real-time reportable terms. The flag indicates that the price for this trade is not to be construed as being indicative of the market for standardised trades with otherwise identical reportable terms.
	 */
	Boolean getNonStandardTerms();
	/**
	 * Indicates that the price does not reflect the current market. For example, in a credit trade where the two counterparties are not of equal credit standing, there is no initial margin and one party pays collateral to the other in the form of an add-on to the price (say a price that would otherwise be 100 at the market is struck at 105 to include the collateral, resulting in a very off-market looking price.)
	 */
	Boolean getOffMarketPrice();
	/**
	 * Describes why the price of this trade does not reflect the current market price. For example, the trade may have been traded off-market as part of a termination or compression operation.
	 */
	List<? extends PricingContext> getPricingContext();
	/**
	 * Specifies whether the sender of this trade considers it to be a large notional trade or block trade for reporting purposes, and thus eligible for delayed public reporting. Normally this will only be applicable for off-facility trades.
	 */
	Boolean getLargeSizeTrade();
	/**
	 * Used to describe how the trade was executed, e.g. via voice or electronically.
	 */
	ExecutionType getExecutionType();
	/**
	 * Used to describe the type of venue where trade was executed, e.g via an execution facility or privately.
	 */
	ExecutionVenueType getExecutionVenueType();
	/**
	 * Used to describe how the trade was or will be verified, e.g via a confirmation facility, via private electronic service, or via written documentation. This affect the timing of real-time reporting requirements. This field is provisional pending detailed confirmation of the data requirements, and may not be included in subsequent working drafts.
	 */
	VerificationMethod getVerificationMethod();
	/**
	 * Used to describe how the trade was confirmed, e.g via a confirmation facility, via private electronic service, or via written documentation. This affects the process flow for confirmation messages. This field is provisional pending detailed confirmation of the data requirements, and may not be included in subsequent working drafts.
	 */
	ConfirmationMethod getConfirmationMethod();
	/**
	 * Specifies whether this trade is a result of compression activity.
	 */
	Boolean getCompressedTrade();
	TransactionClassificationModel getTransactionClassificationModel();
	/**
	 * Used to report whether the trade is in dispute
	 */
	Boolean getIsDisputed();

	/*********************** Build Methods  ***********************/
	PartyTradeInformation build();
	
	PartyTradeInformation.PartyTradeInformationBuilder toBuilder();
	
	static PartyTradeInformation.PartyTradeInformationBuilder builder() {
		return new PartyTradeInformation.PartyTradeInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTradeInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyTradeInformation> getType() {
		return PartyTradeInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("unit"), processor, Unit.class, getUnit());
		processRosetta(path.newSubPath("relatedBusinessUnit"), processor, RelatedBusinessUnit.class, getRelatedBusinessUnit());
		processRosetta(path.newSubPath("relatedPerson"), processor, RelatedPerson.class, getRelatedPerson());
		processRosetta(path.newSubPath("algorithm"), processor, Algorithm.class, getAlgorithm());
		processor.processBasic(path.newSubPath("isAccountingHedge"), Boolean.class, getIsAccountingHedge(), this);
		processRosetta(path.newSubPath("category"), processor, TradeCategory.class, getCategory());
		processRosetta(path.newSubPath("trader"), processor, Trader.class, getTrader());
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processRosetta(path.newSubPath("timestamps"), processor, TradeProcessingTimestamps.class, getTimestamps());
		processor.processBasic(path.newSubPath("intentToAllocate"), Boolean.class, getIntentToAllocate(), this);
		processRosetta(path.newSubPath("allocationStatus"), processor, AllocationReportingStatus.class, getAllocationStatus());
		processor.processBasic(path.newSubPath("intentToClear"), Boolean.class, getIntentToClear(), this);
		processRosetta(path.newSubPath("clearingStatus"), processor, ClearingStatusValue.class, getClearingStatus());
		processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.class, getCollateralizationType());
		processRosetta(path.newSubPath("collateralPortfolio"), processor, PortfolioName.class, getCollateralPortfolio());
		processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegime.class, getReportingRegime());
		processRosetta(path.newSubPath("partyTradeInformationSequence"), processor, PartyTradeInformationSequence.class, getPartyTradeInformationSequence());
		processRosetta(path.newSubPath("endUserExceptionDeclaration"), processor, EndUserExceptionDeclaration.class, getEndUserExceptionDeclaration());
		processor.processBasic(path.newSubPath("nonStandardTerms"), Boolean.class, getNonStandardTerms(), this);
		processor.processBasic(path.newSubPath("offMarketPrice"), Boolean.class, getOffMarketPrice(), this);
		processRosetta(path.newSubPath("pricingContext"), processor, PricingContext.class, getPricingContext());
		processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
		processRosetta(path.newSubPath("executionType"), processor, ExecutionType.class, getExecutionType());
		processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.class, getExecutionVenueType());
		processRosetta(path.newSubPath("verificationMethod"), processor, VerificationMethod.class, getVerificationMethod());
		processRosetta(path.newSubPath("confirmationMethod"), processor, ConfirmationMethod.class, getConfirmationMethod());
		processor.processBasic(path.newSubPath("compressedTrade"), Boolean.class, getCompressedTrade(), this);
		processRosetta(path.newSubPath("transactionClassificationModel"), processor, TransactionClassificationModel.class, getTransactionClassificationModel());
		processor.processBasic(path.newSubPath("isDisputed"), Boolean.class, getIsDisputed(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTradeInformationBuilder extends PartyTradeInformation, RosettaModelObjectBuilder {
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index);
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		ReportingRole.ReportingRoleBuilder getReportingRole();
		Unit.UnitBuilder getOrCreateUnit(int _index);
		List<? extends Unit.UnitBuilder> getUnit();
		RelatedBusinessUnit.RelatedBusinessUnitBuilder getOrCreateRelatedBusinessUnit(int _index);
		List<? extends RelatedBusinessUnit.RelatedBusinessUnitBuilder> getRelatedBusinessUnit();
		RelatedPerson.RelatedPersonBuilder getOrCreateRelatedPerson(int _index);
		List<? extends RelatedPerson.RelatedPersonBuilder> getRelatedPerson();
		Algorithm.AlgorithmBuilder getOrCreateAlgorithm(int _index);
		List<? extends Algorithm.AlgorithmBuilder> getAlgorithm();
		TradeCategory.TradeCategoryBuilder getOrCreateCategory(int _index);
		List<? extends TradeCategory.TradeCategoryBuilder> getCategory();
		Trader.TraderBuilder getOrCreateTrader(int _index);
		List<? extends Trader.TraderBuilder> getTrader();
		ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime();
		ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime();
		TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getOrCreateTimestamps();
		TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getTimestamps();
		AllocationReportingStatus.AllocationReportingStatusBuilder getOrCreateAllocationStatus();
		AllocationReportingStatus.AllocationReportingStatusBuilder getAllocationStatus();
		ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatus();
		ClearingStatusValue.ClearingStatusValueBuilder getClearingStatus();
		CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType();
		CollateralizationType.CollateralizationTypeBuilder getCollateralizationType();
		PortfolioName.PortfolioNameBuilder getOrCreateCollateralPortfolio();
		PortfolioName.PortfolioNameBuilder getCollateralPortfolio();
		ReportingRegime.ReportingRegimeBuilder getOrCreateReportingRegime(int _index);
		List<? extends ReportingRegime.ReportingRegimeBuilder> getReportingRegime();
		PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder getOrCreatePartyTradeInformationSequence();
		PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder getPartyTradeInformationSequence();
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getOrCreateEndUserExceptionDeclaration();
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getEndUserExceptionDeclaration();
		PricingContext.PricingContextBuilder getOrCreatePricingContext(int _index);
		List<? extends PricingContext.PricingContextBuilder> getPricingContext();
		ExecutionType.ExecutionTypeBuilder getOrCreateExecutionType();
		ExecutionType.ExecutionTypeBuilder getExecutionType();
		ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType();
		ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType();
		VerificationMethod.VerificationMethodBuilder getOrCreateVerificationMethod();
		VerificationMethod.VerificationMethodBuilder getVerificationMethod();
		ConfirmationMethod.ConfirmationMethodBuilder getOrCreateConfirmationMethod();
		ConfirmationMethod.ConfirmationMethodBuilder getConfirmationMethod();
		TransactionClassificationModel.TransactionClassificationModelBuilder getOrCreateTransactionClassificationModel();
		TransactionClassificationModel.TransactionClassificationModelBuilder getTransactionClassificationModel();
		PartyTradeInformation.PartyTradeInformationBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty0);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty2);
		PartyTradeInformation.PartyTradeInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty3);
		PartyTradeInformation.PartyTradeInformationBuilder setReportingRole(ReportingRole reportingRole);
		PartyTradeInformation.PartyTradeInformationBuilder addUnit(Unit unit0);
		PartyTradeInformation.PartyTradeInformationBuilder addUnit(Unit unit1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addUnit(List<? extends Unit> unit2);
		PartyTradeInformation.PartyTradeInformationBuilder setUnit(List<? extends Unit> unit3);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(RelatedBusinessUnit relatedBusinessUnit0);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(RelatedBusinessUnit relatedBusinessUnit1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(List<? extends RelatedBusinessUnit> relatedBusinessUnit2);
		PartyTradeInformation.PartyTradeInformationBuilder setRelatedBusinessUnit(List<? extends RelatedBusinessUnit> relatedBusinessUnit3);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(RelatedPerson relatedPerson0);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(RelatedPerson relatedPerson1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(List<? extends RelatedPerson> relatedPerson2);
		PartyTradeInformation.PartyTradeInformationBuilder setRelatedPerson(List<? extends RelatedPerson> relatedPerson3);
		PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(Algorithm algorithm0);
		PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(Algorithm algorithm1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(List<? extends Algorithm> algorithm2);
		PartyTradeInformation.PartyTradeInformationBuilder setAlgorithm(List<? extends Algorithm> algorithm3);
		PartyTradeInformation.PartyTradeInformationBuilder setIsAccountingHedge(Boolean isAccountingHedge);
		PartyTradeInformation.PartyTradeInformationBuilder addCategory(TradeCategory category0);
		PartyTradeInformation.PartyTradeInformationBuilder addCategory(TradeCategory category1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addCategory(List<? extends TradeCategory> category2);
		PartyTradeInformation.PartyTradeInformationBuilder setCategory(List<? extends TradeCategory> category3);
		PartyTradeInformation.PartyTradeInformationBuilder addTrader(Trader trader0);
		PartyTradeInformation.PartyTradeInformationBuilder addTrader(Trader trader1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addTrader(List<? extends Trader> trader2);
		PartyTradeInformation.PartyTradeInformationBuilder setTrader(List<? extends Trader> trader3);
		PartyTradeInformation.PartyTradeInformationBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		PartyTradeInformation.PartyTradeInformationBuilder setTimestamps(TradeProcessingTimestamps timestamps);
		PartyTradeInformation.PartyTradeInformationBuilder setIntentToAllocate(Boolean intentToAllocate);
		PartyTradeInformation.PartyTradeInformationBuilder setAllocationStatus(AllocationReportingStatus allocationStatus);
		PartyTradeInformation.PartyTradeInformationBuilder setIntentToClear(Boolean intentToClear);
		PartyTradeInformation.PartyTradeInformationBuilder setClearingStatus(ClearingStatusValue clearingStatus);
		PartyTradeInformation.PartyTradeInformationBuilder setCollateralizationType(CollateralizationType collateralizationType);
		PartyTradeInformation.PartyTradeInformationBuilder setCollateralPortfolio(PortfolioName collateralPortfolio);
		PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(ReportingRegime reportingRegime0);
		PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(ReportingRegime reportingRegime1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(List<? extends ReportingRegime> reportingRegime2);
		PartyTradeInformation.PartyTradeInformationBuilder setReportingRegime(List<? extends ReportingRegime> reportingRegime3);
		PartyTradeInformation.PartyTradeInformationBuilder setPartyTradeInformationSequence(PartyTradeInformationSequence partyTradeInformationSequence);
		PartyTradeInformation.PartyTradeInformationBuilder setEndUserExceptionDeclaration(EndUserExceptionDeclaration endUserExceptionDeclaration);
		PartyTradeInformation.PartyTradeInformationBuilder setNonStandardTerms(Boolean nonStandardTerms);
		PartyTradeInformation.PartyTradeInformationBuilder setOffMarketPrice(Boolean offMarketPrice);
		PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(PricingContext pricingContext0);
		PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(PricingContext pricingContext1, int _idx);
		PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(List<? extends PricingContext> pricingContext2);
		PartyTradeInformation.PartyTradeInformationBuilder setPricingContext(List<? extends PricingContext> pricingContext3);
		PartyTradeInformation.PartyTradeInformationBuilder setLargeSizeTrade(Boolean largeSizeTrade);
		PartyTradeInformation.PartyTradeInformationBuilder setExecutionType(ExecutionType executionType);
		PartyTradeInformation.PartyTradeInformationBuilder setExecutionVenueType(ExecutionVenueType executionVenueType);
		PartyTradeInformation.PartyTradeInformationBuilder setVerificationMethod(VerificationMethod verificationMethod);
		PartyTradeInformation.PartyTradeInformationBuilder setConfirmationMethod(ConfirmationMethod confirmationMethod);
		PartyTradeInformation.PartyTradeInformationBuilder setCompressedTrade(Boolean compressedTrade);
		PartyTradeInformation.PartyTradeInformationBuilder setTransactionClassificationModel(TransactionClassificationModel transactionClassificationModel);
		PartyTradeInformation.PartyTradeInformationBuilder setIsDisputed(Boolean isDisputed);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("unit"), processor, Unit.UnitBuilder.class, getUnit());
			processRosetta(path.newSubPath("relatedBusinessUnit"), processor, RelatedBusinessUnit.RelatedBusinessUnitBuilder.class, getRelatedBusinessUnit());
			processRosetta(path.newSubPath("relatedPerson"), processor, RelatedPerson.RelatedPersonBuilder.class, getRelatedPerson());
			processRosetta(path.newSubPath("algorithm"), processor, Algorithm.AlgorithmBuilder.class, getAlgorithm());
			processor.processBasic(path.newSubPath("isAccountingHedge"), Boolean.class, getIsAccountingHedge(), this);
			processRosetta(path.newSubPath("category"), processor, TradeCategory.TradeCategoryBuilder.class, getCategory());
			processRosetta(path.newSubPath("trader"), processor, Trader.TraderBuilder.class, getTrader());
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processRosetta(path.newSubPath("timestamps"), processor, TradeProcessingTimestamps.TradeProcessingTimestampsBuilder.class, getTimestamps());
			processor.processBasic(path.newSubPath("intentToAllocate"), Boolean.class, getIntentToAllocate(), this);
			processRosetta(path.newSubPath("allocationStatus"), processor, AllocationReportingStatus.AllocationReportingStatusBuilder.class, getAllocationStatus());
			processor.processBasic(path.newSubPath("intentToClear"), Boolean.class, getIntentToClear(), this);
			processRosetta(path.newSubPath("clearingStatus"), processor, ClearingStatusValue.ClearingStatusValueBuilder.class, getClearingStatus());
			processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.CollateralizationTypeBuilder.class, getCollateralizationType());
			processRosetta(path.newSubPath("collateralPortfolio"), processor, PortfolioName.PortfolioNameBuilder.class, getCollateralPortfolio());
			processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegime.ReportingRegimeBuilder.class, getReportingRegime());
			processRosetta(path.newSubPath("partyTradeInformationSequence"), processor, PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder.class, getPartyTradeInformationSequence());
			processRosetta(path.newSubPath("endUserExceptionDeclaration"), processor, EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder.class, getEndUserExceptionDeclaration());
			processor.processBasic(path.newSubPath("nonStandardTerms"), Boolean.class, getNonStandardTerms(), this);
			processor.processBasic(path.newSubPath("offMarketPrice"), Boolean.class, getOffMarketPrice(), this);
			processRosetta(path.newSubPath("pricingContext"), processor, PricingContext.PricingContextBuilder.class, getPricingContext());
			processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
			processRosetta(path.newSubPath("executionType"), processor, ExecutionType.ExecutionTypeBuilder.class, getExecutionType());
			processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.ExecutionVenueTypeBuilder.class, getExecutionVenueType());
			processRosetta(path.newSubPath("verificationMethod"), processor, VerificationMethod.VerificationMethodBuilder.class, getVerificationMethod());
			processRosetta(path.newSubPath("confirmationMethod"), processor, ConfirmationMethod.ConfirmationMethodBuilder.class, getConfirmationMethod());
			processor.processBasic(path.newSubPath("compressedTrade"), Boolean.class, getCompressedTrade(), this);
			processRosetta(path.newSubPath("transactionClassificationModel"), processor, TransactionClassificationModel.TransactionClassificationModelBuilder.class, getTransactionClassificationModel());
			processor.processBasic(path.newSubPath("isDisputed"), Boolean.class, getIsDisputed(), this);
		}
		

		PartyTradeInformation.PartyTradeInformationBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTradeInformation  ***********************/
	class PartyTradeInformationImpl implements PartyTradeInformation {
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final List<? extends RelatedParty> relatedParty;
		private final ReportingRole reportingRole;
		private final List<? extends Unit> unit;
		private final List<? extends RelatedBusinessUnit> relatedBusinessUnit;
		private final List<? extends RelatedPerson> relatedPerson;
		private final List<? extends Algorithm> algorithm;
		private final Boolean isAccountingHedge;
		private final List<? extends TradeCategory> category;
		private final List<? extends Trader> trader;
		private final ExecutionDateTime executionDateTime;
		private final TradeProcessingTimestamps timestamps;
		private final Boolean intentToAllocate;
		private final AllocationReportingStatus allocationStatus;
		private final Boolean intentToClear;
		private final ClearingStatusValue clearingStatus;
		private final CollateralizationType collateralizationType;
		private final PortfolioName collateralPortfolio;
		private final List<? extends ReportingRegime> reportingRegime;
		private final PartyTradeInformationSequence partyTradeInformationSequence;
		private final EndUserExceptionDeclaration endUserExceptionDeclaration;
		private final Boolean nonStandardTerms;
		private final Boolean offMarketPrice;
		private final List<? extends PricingContext> pricingContext;
		private final Boolean largeSizeTrade;
		private final ExecutionType executionType;
		private final ExecutionVenueType executionVenueType;
		private final VerificationMethod verificationMethod;
		private final ConfirmationMethod confirmationMethod;
		private final Boolean compressedTrade;
		private final TransactionClassificationModel transactionClassificationModel;
		private final Boolean isDisputed;
		
		protected PartyTradeInformationImpl(PartyTradeInformation.PartyTradeInformationBuilder builder) {
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.unit = ofNullable(builder.getUnit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relatedBusinessUnit = ofNullable(builder.getRelatedBusinessUnit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relatedPerson = ofNullable(builder.getRelatedPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.algorithm = ofNullable(builder.getAlgorithm()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.isAccountingHedge = builder.getIsAccountingHedge();
			this.category = ofNullable(builder.getCategory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.trader = ofNullable(builder.getTrader()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.timestamps = ofNullable(builder.getTimestamps()).map(f->f.build()).orElse(null);
			this.intentToAllocate = builder.getIntentToAllocate();
			this.allocationStatus = ofNullable(builder.getAllocationStatus()).map(f->f.build()).orElse(null);
			this.intentToClear = builder.getIntentToClear();
			this.clearingStatus = ofNullable(builder.getClearingStatus()).map(f->f.build()).orElse(null);
			this.collateralizationType = ofNullable(builder.getCollateralizationType()).map(f->f.build()).orElse(null);
			this.collateralPortfolio = ofNullable(builder.getCollateralPortfolio()).map(f->f.build()).orElse(null);
			this.reportingRegime = ofNullable(builder.getReportingRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeInformationSequence = ofNullable(builder.getPartyTradeInformationSequence()).map(f->f.build()).orElse(null);
			this.endUserExceptionDeclaration = ofNullable(builder.getEndUserExceptionDeclaration()).map(f->f.build()).orElse(null);
			this.nonStandardTerms = builder.getNonStandardTerms();
			this.offMarketPrice = builder.getOffMarketPrice();
			this.pricingContext = ofNullable(builder.getPricingContext()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.largeSizeTrade = builder.getLargeSizeTrade();
			this.executionType = ofNullable(builder.getExecutionType()).map(f->f.build()).orElse(null);
			this.executionVenueType = ofNullable(builder.getExecutionVenueType()).map(f->f.build()).orElse(null);
			this.verificationMethod = ofNullable(builder.getVerificationMethod()).map(f->f.build()).orElse(null);
			this.confirmationMethod = ofNullable(builder.getConfirmationMethod()).map(f->f.build()).orElse(null);
			this.compressedTrade = builder.getCompressedTrade();
			this.transactionClassificationModel = ofNullable(builder.getTransactionClassificationModel()).map(f->f.build()).orElse(null);
			this.isDisputed = builder.getIsDisputed();
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		public ReportingRole getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("unit")
		public List<? extends Unit> getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("relatedBusinessUnit")
		public List<? extends RelatedBusinessUnit> getRelatedBusinessUnit() {
			return relatedBusinessUnit;
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		public List<? extends RelatedPerson> getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public List<? extends Algorithm> getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("isAccountingHedge")
		public Boolean getIsAccountingHedge() {
			return isAccountingHedge;
		}
		
		@Override
		@RosettaAttribute("category")
		public List<? extends TradeCategory> getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("trader")
		public List<? extends Trader> getTrader() {
			return trader;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		public ExecutionDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("timestamps")
		public TradeProcessingTimestamps getTimestamps() {
			return timestamps;
		}
		
		@Override
		@RosettaAttribute("intentToAllocate")
		public Boolean getIntentToAllocate() {
			return intentToAllocate;
		}
		
		@Override
		@RosettaAttribute("allocationStatus")
		public AllocationReportingStatus getAllocationStatus() {
			return allocationStatus;
		}
		
		@Override
		@RosettaAttribute("intentToClear")
		public Boolean getIntentToClear() {
			return intentToClear;
		}
		
		@Override
		@RosettaAttribute("clearingStatus")
		public ClearingStatusValue getClearingStatus() {
			return clearingStatus;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		public CollateralizationType getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolio")
		public PortfolioName getCollateralPortfolio() {
			return collateralPortfolio;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		public List<? extends ReportingRegime> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		@RosettaAttribute("partyTradeInformationSequence")
		public PartyTradeInformationSequence getPartyTradeInformationSequence() {
			return partyTradeInformationSequence;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionDeclaration")
		public EndUserExceptionDeclaration getEndUserExceptionDeclaration() {
			return endUserExceptionDeclaration;
		}
		
		@Override
		@RosettaAttribute("nonStandardTerms")
		public Boolean getNonStandardTerms() {
			return nonStandardTerms;
		}
		
		@Override
		@RosettaAttribute("offMarketPrice")
		public Boolean getOffMarketPrice() {
			return offMarketPrice;
		}
		
		@Override
		@RosettaAttribute("pricingContext")
		public List<? extends PricingContext> getPricingContext() {
			return pricingContext;
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("executionType")
		public ExecutionType getExecutionType() {
			return executionType;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		public ExecutionVenueType getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		@RosettaAttribute("verificationMethod")
		public VerificationMethod getVerificationMethod() {
			return verificationMethod;
		}
		
		@Override
		@RosettaAttribute("confirmationMethod")
		public ConfirmationMethod getConfirmationMethod() {
			return confirmationMethod;
		}
		
		@Override
		@RosettaAttribute("compressedTrade")
		public Boolean getCompressedTrade() {
			return compressedTrade;
		}
		
		@Override
		@RosettaAttribute("transactionClassificationModel")
		public TransactionClassificationModel getTransactionClassificationModel() {
			return transactionClassificationModel;
		}
		
		@Override
		@RosettaAttribute("isDisputed")
		public Boolean getIsDisputed() {
			return isDisputed;
		}
		
		@Override
		public PartyTradeInformation build() {
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder toBuilder() {
			PartyTradeInformation.PartyTradeInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTradeInformation.PartyTradeInformationBuilder builder) {
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getRelatedBusinessUnit()).ifPresent(builder::setRelatedBusinessUnit);
			ofNullable(getRelatedPerson()).ifPresent(builder::setRelatedPerson);
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
			ofNullable(getIsAccountingHedge()).ifPresent(builder::setIsAccountingHedge);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getTrader()).ifPresent(builder::setTrader);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getTimestamps()).ifPresent(builder::setTimestamps);
			ofNullable(getIntentToAllocate()).ifPresent(builder::setIntentToAllocate);
			ofNullable(getAllocationStatus()).ifPresent(builder::setAllocationStatus);
			ofNullable(getIntentToClear()).ifPresent(builder::setIntentToClear);
			ofNullable(getClearingStatus()).ifPresent(builder::setClearingStatus);
			ofNullable(getCollateralizationType()).ifPresent(builder::setCollateralizationType);
			ofNullable(getCollateralPortfolio()).ifPresent(builder::setCollateralPortfolio);
			ofNullable(getReportingRegime()).ifPresent(builder::setReportingRegime);
			ofNullable(getPartyTradeInformationSequence()).ifPresent(builder::setPartyTradeInformationSequence);
			ofNullable(getEndUserExceptionDeclaration()).ifPresent(builder::setEndUserExceptionDeclaration);
			ofNullable(getNonStandardTerms()).ifPresent(builder::setNonStandardTerms);
			ofNullable(getOffMarketPrice()).ifPresent(builder::setOffMarketPrice);
			ofNullable(getPricingContext()).ifPresent(builder::setPricingContext);
			ofNullable(getLargeSizeTrade()).ifPresent(builder::setLargeSizeTrade);
			ofNullable(getExecutionType()).ifPresent(builder::setExecutionType);
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
			ofNullable(getVerificationMethod()).ifPresent(builder::setVerificationMethod);
			ofNullable(getConfirmationMethod()).ifPresent(builder::setConfirmationMethod);
			ofNullable(getCompressedTrade()).ifPresent(builder::setCompressedTrade);
			ofNullable(getTransactionClassificationModel()).ifPresent(builder::setTransactionClassificationModel);
			ofNullable(getIsDisputed()).ifPresent(builder::setIsDisputed);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(unit, _that.getUnit())) return false;
			if (!ListEquals.listEquals(relatedBusinessUnit, _that.getRelatedBusinessUnit())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!ListEquals.listEquals(algorithm, _that.getAlgorithm())) return false;
			if (!Objects.equals(isAccountingHedge, _that.getIsAccountingHedge())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!ListEquals.listEquals(trader, _that.getTrader())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(timestamps, _that.getTimestamps())) return false;
			if (!Objects.equals(intentToAllocate, _that.getIntentToAllocate())) return false;
			if (!Objects.equals(allocationStatus, _that.getAllocationStatus())) return false;
			if (!Objects.equals(intentToClear, _that.getIntentToClear())) return false;
			if (!Objects.equals(clearingStatus, _that.getClearingStatus())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(collateralPortfolio, _that.getCollateralPortfolio())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			if (!Objects.equals(partyTradeInformationSequence, _that.getPartyTradeInformationSequence())) return false;
			if (!Objects.equals(endUserExceptionDeclaration, _that.getEndUserExceptionDeclaration())) return false;
			if (!Objects.equals(nonStandardTerms, _that.getNonStandardTerms())) return false;
			if (!Objects.equals(offMarketPrice, _that.getOffMarketPrice())) return false;
			if (!ListEquals.listEquals(pricingContext, _that.getPricingContext())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(executionType, _that.getExecutionType())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(verificationMethod, _that.getVerificationMethod())) return false;
			if (!Objects.equals(confirmationMethod, _that.getConfirmationMethod())) return false;
			if (!Objects.equals(compressedTrade, _that.getCompressedTrade())) return false;
			if (!Objects.equals(transactionClassificationModel, _that.getTransactionClassificationModel())) return false;
			if (!Objects.equals(isDisputed, _that.getIsDisputed())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (relatedBusinessUnit != null ? relatedBusinessUnit.hashCode() : 0);
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (isAccountingHedge != null ? isAccountingHedge.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (trader != null ? trader.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (timestamps != null ? timestamps.hashCode() : 0);
			_result = 31 * _result + (intentToAllocate != null ? intentToAllocate.hashCode() : 0);
			_result = 31 * _result + (allocationStatus != null ? allocationStatus.hashCode() : 0);
			_result = 31 * _result + (intentToClear != null ? intentToClear.hashCode() : 0);
			_result = 31 * _result + (clearingStatus != null ? clearingStatus.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolio != null ? collateralPortfolio.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformationSequence != null ? partyTradeInformationSequence.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionDeclaration != null ? endUserExceptionDeclaration.hashCode() : 0);
			_result = 31 * _result + (nonStandardTerms != null ? nonStandardTerms.hashCode() : 0);
			_result = 31 * _result + (offMarketPrice != null ? offMarketPrice.hashCode() : 0);
			_result = 31 * _result + (pricingContext != null ? pricingContext.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (executionType != null ? executionType.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (verificationMethod != null ? verificationMethod.hashCode() : 0);
			_result = 31 * _result + (confirmationMethod != null ? confirmationMethod.hashCode() : 0);
			_result = 31 * _result + (compressedTrade != null ? compressedTrade.hashCode() : 0);
			_result = 31 * _result + (transactionClassificationModel != null ? transactionClassificationModel.hashCode() : 0);
			_result = 31 * _result + (isDisputed != null ? isDisputed.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeInformation {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"unit=" + this.unit + ", " +
				"relatedBusinessUnit=" + this.relatedBusinessUnit + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"algorithm=" + this.algorithm + ", " +
				"isAccountingHedge=" + this.isAccountingHedge + ", " +
				"category=" + this.category + ", " +
				"trader=" + this.trader + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"timestamps=" + this.timestamps + ", " +
				"intentToAllocate=" + this.intentToAllocate + ", " +
				"allocationStatus=" + this.allocationStatus + ", " +
				"intentToClear=" + this.intentToClear + ", " +
				"clearingStatus=" + this.clearingStatus + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"collateralPortfolio=" + this.collateralPortfolio + ", " +
				"reportingRegime=" + this.reportingRegime + ", " +
				"partyTradeInformationSequence=" + this.partyTradeInformationSequence + ", " +
				"endUserExceptionDeclaration=" + this.endUserExceptionDeclaration + ", " +
				"nonStandardTerms=" + this.nonStandardTerms + ", " +
				"offMarketPrice=" + this.offMarketPrice + ", " +
				"pricingContext=" + this.pricingContext + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"executionType=" + this.executionType + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"verificationMethod=" + this.verificationMethod + ", " +
				"confirmationMethod=" + this.confirmationMethod + ", " +
				"compressedTrade=" + this.compressedTrade + ", " +
				"transactionClassificationModel=" + this.transactionClassificationModel + ", " +
				"isDisputed=" + this.isDisputed +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyTradeInformation  ***********************/
	class PartyTradeInformationBuilderImpl implements PartyTradeInformation.PartyTradeInformationBuilder {
	
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<Unit.UnitBuilder> unit = new ArrayList<>();
		protected List<RelatedBusinessUnit.RelatedBusinessUnitBuilder> relatedBusinessUnit = new ArrayList<>();
		protected List<RelatedPerson.RelatedPersonBuilder> relatedPerson = new ArrayList<>();
		protected List<Algorithm.AlgorithmBuilder> algorithm = new ArrayList<>();
		protected Boolean isAccountingHedge;
		protected List<TradeCategory.TradeCategoryBuilder> category = new ArrayList<>();
		protected List<Trader.TraderBuilder> trader = new ArrayList<>();
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected TradeProcessingTimestamps.TradeProcessingTimestampsBuilder timestamps;
		protected Boolean intentToAllocate;
		protected AllocationReportingStatus.AllocationReportingStatusBuilder allocationStatus;
		protected Boolean intentToClear;
		protected ClearingStatusValue.ClearingStatusValueBuilder clearingStatus;
		protected CollateralizationType.CollateralizationTypeBuilder collateralizationType;
		protected PortfolioName.PortfolioNameBuilder collateralPortfolio;
		protected List<ReportingRegime.ReportingRegimeBuilder> reportingRegime = new ArrayList<>();
		protected PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder partyTradeInformationSequence;
		protected EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder endUserExceptionDeclaration;
		protected Boolean nonStandardTerms;
		protected Boolean offMarketPrice;
		protected List<PricingContext.PricingContextBuilder> pricingContext = new ArrayList<>();
		protected Boolean largeSizeTrade;
		protected ExecutionType.ExecutionTypeBuilder executionType;
		protected ExecutionVenueType.ExecutionVenueTypeBuilder executionVenueType;
		protected VerificationMethod.VerificationMethodBuilder verificationMethod;
		protected ConfirmationMethod.ConfirmationMethodBuilder confirmationMethod;
		protected Boolean compressedTrade;
		protected TransactionClassificationModel.TransactionClassificationModelBuilder transactionClassificationModel;
		protected Boolean isDisputed;
	
		public PartyTradeInformationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel() {
			PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder result;
			if (partyAndAccountReferencesModel!=null) {
				result = partyAndAccountReferencesModel;
			}
			else {
				result = partyAndAccountReferencesModel = PartyAndAccountReferencesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index) {
		
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			RelatedParty.RelatedPartyBuilder result;
			return getIndex(relatedParty, _index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		public ReportingRole.ReportingRoleBuilder getReportingRole() {
			return reportingRole;
		}
		
		@Override
		public ReportingRole.ReportingRoleBuilder getOrCreateReportingRole() {
			ReportingRole.ReportingRoleBuilder result;
			if (reportingRole!=null) {
				result = reportingRole;
			}
			else {
				result = reportingRole = ReportingRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unit")
		public List<? extends Unit.UnitBuilder> getUnit() {
			return unit;
		}
		
		public Unit.UnitBuilder getOrCreateUnit(int _index) {
		
			if (unit==null) {
				this.unit = new ArrayList<>();
			}
			Unit.UnitBuilder result;
			return getIndex(unit, _index, () -> {
						Unit.UnitBuilder newUnit = Unit.builder();
						return newUnit;
					});
		}
		
		@Override
		@RosettaAttribute("relatedBusinessUnit")
		public List<? extends RelatedBusinessUnit.RelatedBusinessUnitBuilder> getRelatedBusinessUnit() {
			return relatedBusinessUnit;
		}
		
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder getOrCreateRelatedBusinessUnit(int _index) {
		
			if (relatedBusinessUnit==null) {
				this.relatedBusinessUnit = new ArrayList<>();
			}
			RelatedBusinessUnit.RelatedBusinessUnitBuilder result;
			return getIndex(relatedBusinessUnit, _index, () -> {
						RelatedBusinessUnit.RelatedBusinessUnitBuilder newRelatedBusinessUnit = RelatedBusinessUnit.builder();
						return newRelatedBusinessUnit;
					});
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		public List<? extends RelatedPerson.RelatedPersonBuilder> getRelatedPerson() {
			return relatedPerson;
		}
		
		public RelatedPerson.RelatedPersonBuilder getOrCreateRelatedPerson(int _index) {
		
			if (relatedPerson==null) {
				this.relatedPerson = new ArrayList<>();
			}
			RelatedPerson.RelatedPersonBuilder result;
			return getIndex(relatedPerson, _index, () -> {
						RelatedPerson.RelatedPersonBuilder newRelatedPerson = RelatedPerson.builder();
						return newRelatedPerson;
					});
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public List<? extends Algorithm.AlgorithmBuilder> getAlgorithm() {
			return algorithm;
		}
		
		public Algorithm.AlgorithmBuilder getOrCreateAlgorithm(int _index) {
		
			if (algorithm==null) {
				this.algorithm = new ArrayList<>();
			}
			Algorithm.AlgorithmBuilder result;
			return getIndex(algorithm, _index, () -> {
						Algorithm.AlgorithmBuilder newAlgorithm = Algorithm.builder();
						return newAlgorithm;
					});
		}
		
		@Override
		@RosettaAttribute("isAccountingHedge")
		public Boolean getIsAccountingHedge() {
			return isAccountingHedge;
		}
		
		@Override
		@RosettaAttribute("category")
		public List<? extends TradeCategory.TradeCategoryBuilder> getCategory() {
			return category;
		}
		
		public TradeCategory.TradeCategoryBuilder getOrCreateCategory(int _index) {
		
			if (category==null) {
				this.category = new ArrayList<>();
			}
			TradeCategory.TradeCategoryBuilder result;
			return getIndex(category, _index, () -> {
						TradeCategory.TradeCategoryBuilder newCategory = TradeCategory.builder();
						return newCategory;
					});
		}
		
		@Override
		@RosettaAttribute("trader")
		public List<? extends Trader.TraderBuilder> getTrader() {
			return trader;
		}
		
		public Trader.TraderBuilder getOrCreateTrader(int _index) {
		
			if (trader==null) {
				this.trader = new ArrayList<>();
			}
			Trader.TraderBuilder result;
			return getIndex(trader, _index, () -> {
						Trader.TraderBuilder newTrader = Trader.builder();
						return newTrader;
					});
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		public ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime() {
			ExecutionDateTime.ExecutionDateTimeBuilder result;
			if (executionDateTime!=null) {
				result = executionDateTime;
			}
			else {
				result = executionDateTime = ExecutionDateTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("timestamps")
		public TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getTimestamps() {
			return timestamps;
		}
		
		@Override
		public TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getOrCreateTimestamps() {
			TradeProcessingTimestamps.TradeProcessingTimestampsBuilder result;
			if (timestamps!=null) {
				result = timestamps;
			}
			else {
				result = timestamps = TradeProcessingTimestamps.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intentToAllocate")
		public Boolean getIntentToAllocate() {
			return intentToAllocate;
		}
		
		@Override
		@RosettaAttribute("allocationStatus")
		public AllocationReportingStatus.AllocationReportingStatusBuilder getAllocationStatus() {
			return allocationStatus;
		}
		
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder getOrCreateAllocationStatus() {
			AllocationReportingStatus.AllocationReportingStatusBuilder result;
			if (allocationStatus!=null) {
				result = allocationStatus;
			}
			else {
				result = allocationStatus = AllocationReportingStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intentToClear")
		public Boolean getIntentToClear() {
			return intentToClear;
		}
		
		@Override
		@RosettaAttribute("clearingStatus")
		public ClearingStatusValue.ClearingStatusValueBuilder getClearingStatus() {
			return clearingStatus;
		}
		
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatus() {
			ClearingStatusValue.ClearingStatusValueBuilder result;
			if (clearingStatus!=null) {
				result = clearingStatus;
			}
			else {
				result = clearingStatus = ClearingStatusValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		public CollateralizationType.CollateralizationTypeBuilder getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		public CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType() {
			CollateralizationType.CollateralizationTypeBuilder result;
			if (collateralizationType!=null) {
				result = collateralizationType;
			}
			else {
				result = collateralizationType = CollateralizationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolio")
		public PortfolioName.PortfolioNameBuilder getCollateralPortfolio() {
			return collateralPortfolio;
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder getOrCreateCollateralPortfolio() {
			PortfolioName.PortfolioNameBuilder result;
			if (collateralPortfolio!=null) {
				result = collateralPortfolio;
			}
			else {
				result = collateralPortfolio = PortfolioName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		public List<? extends ReportingRegime.ReportingRegimeBuilder> getReportingRegime() {
			return reportingRegime;
		}
		
		public ReportingRegime.ReportingRegimeBuilder getOrCreateReportingRegime(int _index) {
		
			if (reportingRegime==null) {
				this.reportingRegime = new ArrayList<>();
			}
			ReportingRegime.ReportingRegimeBuilder result;
			return getIndex(reportingRegime, _index, () -> {
						ReportingRegime.ReportingRegimeBuilder newReportingRegime = ReportingRegime.builder();
						return newReportingRegime;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeInformationSequence")
		public PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder getPartyTradeInformationSequence() {
			return partyTradeInformationSequence;
		}
		
		@Override
		public PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder getOrCreatePartyTradeInformationSequence() {
			PartyTradeInformationSequence.PartyTradeInformationSequenceBuilder result;
			if (partyTradeInformationSequence!=null) {
				result = partyTradeInformationSequence;
			}
			else {
				result = partyTradeInformationSequence = PartyTradeInformationSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionDeclaration")
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getEndUserExceptionDeclaration() {
			return endUserExceptionDeclaration;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getOrCreateEndUserExceptionDeclaration() {
			EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder result;
			if (endUserExceptionDeclaration!=null) {
				result = endUserExceptionDeclaration;
			}
			else {
				result = endUserExceptionDeclaration = EndUserExceptionDeclaration.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonStandardTerms")
		public Boolean getNonStandardTerms() {
			return nonStandardTerms;
		}
		
		@Override
		@RosettaAttribute("offMarketPrice")
		public Boolean getOffMarketPrice() {
			return offMarketPrice;
		}
		
		@Override
		@RosettaAttribute("pricingContext")
		public List<? extends PricingContext.PricingContextBuilder> getPricingContext() {
			return pricingContext;
		}
		
		public PricingContext.PricingContextBuilder getOrCreatePricingContext(int _index) {
		
			if (pricingContext==null) {
				this.pricingContext = new ArrayList<>();
			}
			PricingContext.PricingContextBuilder result;
			return getIndex(pricingContext, _index, () -> {
						PricingContext.PricingContextBuilder newPricingContext = PricingContext.builder();
						return newPricingContext;
					});
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("executionType")
		public ExecutionType.ExecutionTypeBuilder getExecutionType() {
			return executionType;
		}
		
		@Override
		public ExecutionType.ExecutionTypeBuilder getOrCreateExecutionType() {
			ExecutionType.ExecutionTypeBuilder result;
			if (executionType!=null) {
				result = executionType;
			}
			else {
				result = executionType = ExecutionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		public ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType() {
			ExecutionVenueType.ExecutionVenueTypeBuilder result;
			if (executionVenueType!=null) {
				result = executionVenueType;
			}
			else {
				result = executionVenueType = ExecutionVenueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("verificationMethod")
		public VerificationMethod.VerificationMethodBuilder getVerificationMethod() {
			return verificationMethod;
		}
		
		@Override
		public VerificationMethod.VerificationMethodBuilder getOrCreateVerificationMethod() {
			VerificationMethod.VerificationMethodBuilder result;
			if (verificationMethod!=null) {
				result = verificationMethod;
			}
			else {
				result = verificationMethod = VerificationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("confirmationMethod")
		public ConfirmationMethod.ConfirmationMethodBuilder getConfirmationMethod() {
			return confirmationMethod;
		}
		
		@Override
		public ConfirmationMethod.ConfirmationMethodBuilder getOrCreateConfirmationMethod() {
			ConfirmationMethod.ConfirmationMethodBuilder result;
			if (confirmationMethod!=null) {
				result = confirmationMethod;
			}
			else {
				result = confirmationMethod = ConfirmationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compressedTrade")
		public Boolean getCompressedTrade() {
			return compressedTrade;
		}
		
		@Override
		@RosettaAttribute("transactionClassificationModel")
		public TransactionClassificationModel.TransactionClassificationModelBuilder getTransactionClassificationModel() {
			return transactionClassificationModel;
		}
		
		@Override
		public TransactionClassificationModel.TransactionClassificationModelBuilder getOrCreateTransactionClassificationModel() {
			TransactionClassificationModel.TransactionClassificationModelBuilder result;
			if (transactionClassificationModel!=null) {
				result = transactionClassificationModel;
			}
			else {
				result = transactionClassificationModel = TransactionClassificationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isDisputed")
		public Boolean getIsDisputed() {
			return isDisputed;
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyTradeInformation.PartyTradeInformationBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty) {
			if (relatedParty!=null) this.relatedParty.add(relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty, int _idx) {
			getIndex(this.relatedParty, _idx, () -> relatedParty.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("relatedParty")
		public PartyTradeInformation.PartyTradeInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null)  {
				this.relatedParty = new ArrayList<>();
			}
			else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		public PartyTradeInformation.PartyTradeInformationBuilder setReportingRole(ReportingRole reportingRole) {
			this.reportingRole = reportingRole==null?null:reportingRole.toBuilder();
			return this;
		}
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addUnit(Unit unit) {
			if (unit!=null) this.unit.add(unit.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addUnit(Unit unit, int _idx) {
			getIndex(this.unit, _idx, () -> unit.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addUnit(List<? extends Unit> units) {
			if (units != null) {
				for (Unit toAdd : units) {
					this.unit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("unit")
		public PartyTradeInformation.PartyTradeInformationBuilder setUnit(List<? extends Unit> units) {
			if (units == null)  {
				this.unit = new ArrayList<>();
			}
			else {
				this.unit = units.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(RelatedBusinessUnit relatedBusinessUnit) {
			if (relatedBusinessUnit!=null) this.relatedBusinessUnit.add(relatedBusinessUnit.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(RelatedBusinessUnit relatedBusinessUnit, int _idx) {
			getIndex(this.relatedBusinessUnit, _idx, () -> relatedBusinessUnit.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedBusinessUnit(List<? extends RelatedBusinessUnit> relatedBusinessUnits) {
			if (relatedBusinessUnits != null) {
				for (RelatedBusinessUnit toAdd : relatedBusinessUnits) {
					this.relatedBusinessUnit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("relatedBusinessUnit")
		public PartyTradeInformation.PartyTradeInformationBuilder setRelatedBusinessUnit(List<? extends RelatedBusinessUnit> relatedBusinessUnits) {
			if (relatedBusinessUnits == null)  {
				this.relatedBusinessUnit = new ArrayList<>();
			}
			else {
				this.relatedBusinessUnit = relatedBusinessUnits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(RelatedPerson relatedPerson) {
			if (relatedPerson!=null) this.relatedPerson.add(relatedPerson.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(RelatedPerson relatedPerson, int _idx) {
			getIndex(this.relatedPerson, _idx, () -> relatedPerson.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addRelatedPerson(List<? extends RelatedPerson> relatedPersons) {
			if (relatedPersons != null) {
				for (RelatedPerson toAdd : relatedPersons) {
					this.relatedPerson.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("relatedPerson")
		public PartyTradeInformation.PartyTradeInformationBuilder setRelatedPerson(List<? extends RelatedPerson> relatedPersons) {
			if (relatedPersons == null)  {
				this.relatedPerson = new ArrayList<>();
			}
			else {
				this.relatedPerson = relatedPersons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(Algorithm algorithm) {
			if (algorithm!=null) this.algorithm.add(algorithm.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(Algorithm algorithm, int _idx) {
			getIndex(this.algorithm, _idx, () -> algorithm.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addAlgorithm(List<? extends Algorithm> algorithms) {
			if (algorithms != null) {
				for (Algorithm toAdd : algorithms) {
					this.algorithm.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("algorithm")
		public PartyTradeInformation.PartyTradeInformationBuilder setAlgorithm(List<? extends Algorithm> algorithms) {
			if (algorithms == null)  {
				this.algorithm = new ArrayList<>();
			}
			else {
				this.algorithm = algorithms.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("isAccountingHedge")
		public PartyTradeInformation.PartyTradeInformationBuilder setIsAccountingHedge(Boolean isAccountingHedge) {
			this.isAccountingHedge = isAccountingHedge==null?null:isAccountingHedge;
			return this;
		}
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addCategory(TradeCategory category) {
			if (category!=null) this.category.add(category.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addCategory(TradeCategory category, int _idx) {
			getIndex(this.category, _idx, () -> category.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addCategory(List<? extends TradeCategory> categorys) {
			if (categorys != null) {
				for (TradeCategory toAdd : categorys) {
					this.category.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("category")
		public PartyTradeInformation.PartyTradeInformationBuilder setCategory(List<? extends TradeCategory> categorys) {
			if (categorys == null)  {
				this.category = new ArrayList<>();
			}
			else {
				this.category = categorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addTrader(Trader trader) {
			if (trader!=null) this.trader.add(trader.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addTrader(Trader trader, int _idx) {
			getIndex(this.trader, _idx, () -> trader.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addTrader(List<? extends Trader> traders) {
			if (traders != null) {
				for (Trader toAdd : traders) {
					this.trader.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("trader")
		public PartyTradeInformation.PartyTradeInformationBuilder setTrader(List<? extends Trader> traders) {
			if (traders == null)  {
				this.trader = new ArrayList<>();
			}
			else {
				this.trader = traders.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		public PartyTradeInformation.PartyTradeInformationBuilder setExecutionDateTime(ExecutionDateTime executionDateTime) {
			this.executionDateTime = executionDateTime==null?null:executionDateTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("timestamps")
		public PartyTradeInformation.PartyTradeInformationBuilder setTimestamps(TradeProcessingTimestamps timestamps) {
			this.timestamps = timestamps==null?null:timestamps.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("intentToAllocate")
		public PartyTradeInformation.PartyTradeInformationBuilder setIntentToAllocate(Boolean intentToAllocate) {
			this.intentToAllocate = intentToAllocate==null?null:intentToAllocate;
			return this;
		}
		@Override
		@RosettaAttribute("allocationStatus")
		public PartyTradeInformation.PartyTradeInformationBuilder setAllocationStatus(AllocationReportingStatus allocationStatus) {
			this.allocationStatus = allocationStatus==null?null:allocationStatus.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("intentToClear")
		public PartyTradeInformation.PartyTradeInformationBuilder setIntentToClear(Boolean intentToClear) {
			this.intentToClear = intentToClear==null?null:intentToClear;
			return this;
		}
		@Override
		@RosettaAttribute("clearingStatus")
		public PartyTradeInformation.PartyTradeInformationBuilder setClearingStatus(ClearingStatusValue clearingStatus) {
			this.clearingStatus = clearingStatus==null?null:clearingStatus.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("collateralizationType")
		public PartyTradeInformation.PartyTradeInformationBuilder setCollateralizationType(CollateralizationType collateralizationType) {
			this.collateralizationType = collateralizationType==null?null:collateralizationType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("collateralPortfolio")
		public PartyTradeInformation.PartyTradeInformationBuilder setCollateralPortfolio(PortfolioName collateralPortfolio) {
			this.collateralPortfolio = collateralPortfolio==null?null:collateralPortfolio.toBuilder();
			return this;
		}
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(ReportingRegime reportingRegime) {
			if (reportingRegime!=null) this.reportingRegime.add(reportingRegime.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(ReportingRegime reportingRegime, int _idx) {
			getIndex(this.reportingRegime, _idx, () -> reportingRegime.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addReportingRegime(List<? extends ReportingRegime> reportingRegimes) {
			if (reportingRegimes != null) {
				for (ReportingRegime toAdd : reportingRegimes) {
					this.reportingRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reportingRegime")
		public PartyTradeInformation.PartyTradeInformationBuilder setReportingRegime(List<? extends ReportingRegime> reportingRegimes) {
			if (reportingRegimes == null)  {
				this.reportingRegime = new ArrayList<>();
			}
			else {
				this.reportingRegime = reportingRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyTradeInformationSequence")
		public PartyTradeInformation.PartyTradeInformationBuilder setPartyTradeInformationSequence(PartyTradeInformationSequence partyTradeInformationSequence) {
			this.partyTradeInformationSequence = partyTradeInformationSequence==null?null:partyTradeInformationSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("endUserExceptionDeclaration")
		public PartyTradeInformation.PartyTradeInformationBuilder setEndUserExceptionDeclaration(EndUserExceptionDeclaration endUserExceptionDeclaration) {
			this.endUserExceptionDeclaration = endUserExceptionDeclaration==null?null:endUserExceptionDeclaration.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("nonStandardTerms")
		public PartyTradeInformation.PartyTradeInformationBuilder setNonStandardTerms(Boolean nonStandardTerms) {
			this.nonStandardTerms = nonStandardTerms==null?null:nonStandardTerms;
			return this;
		}
		@Override
		@RosettaAttribute("offMarketPrice")
		public PartyTradeInformation.PartyTradeInformationBuilder setOffMarketPrice(Boolean offMarketPrice) {
			this.offMarketPrice = offMarketPrice==null?null:offMarketPrice;
			return this;
		}
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(PricingContext pricingContext) {
			if (pricingContext!=null) this.pricingContext.add(pricingContext.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(PricingContext pricingContext, int _idx) {
			getIndex(this.pricingContext, _idx, () -> pricingContext.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeInformation.PartyTradeInformationBuilder addPricingContext(List<? extends PricingContext> pricingContexts) {
			if (pricingContexts != null) {
				for (PricingContext toAdd : pricingContexts) {
					this.pricingContext.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("pricingContext")
		public PartyTradeInformation.PartyTradeInformationBuilder setPricingContext(List<? extends PricingContext> pricingContexts) {
			if (pricingContexts == null)  {
				this.pricingContext = new ArrayList<>();
			}
			else {
				this.pricingContext = pricingContexts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		public PartyTradeInformation.PartyTradeInformationBuilder setLargeSizeTrade(Boolean largeSizeTrade) {
			this.largeSizeTrade = largeSizeTrade==null?null:largeSizeTrade;
			return this;
		}
		@Override
		@RosettaAttribute("executionType")
		public PartyTradeInformation.PartyTradeInformationBuilder setExecutionType(ExecutionType executionType) {
			this.executionType = executionType==null?null:executionType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("executionVenueType")
		public PartyTradeInformation.PartyTradeInformationBuilder setExecutionVenueType(ExecutionVenueType executionVenueType) {
			this.executionVenueType = executionVenueType==null?null:executionVenueType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("verificationMethod")
		public PartyTradeInformation.PartyTradeInformationBuilder setVerificationMethod(VerificationMethod verificationMethod) {
			this.verificationMethod = verificationMethod==null?null:verificationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("confirmationMethod")
		public PartyTradeInformation.PartyTradeInformationBuilder setConfirmationMethod(ConfirmationMethod confirmationMethod) {
			this.confirmationMethod = confirmationMethod==null?null:confirmationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compressedTrade")
		public PartyTradeInformation.PartyTradeInformationBuilder setCompressedTrade(Boolean compressedTrade) {
			this.compressedTrade = compressedTrade==null?null:compressedTrade;
			return this;
		}
		@Override
		@RosettaAttribute("transactionClassificationModel")
		public PartyTradeInformation.PartyTradeInformationBuilder setTransactionClassificationModel(TransactionClassificationModel transactionClassificationModel) {
			this.transactionClassificationModel = transactionClassificationModel==null?null:transactionClassificationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isDisputed")
		public PartyTradeInformation.PartyTradeInformationBuilder setIsDisputed(Boolean isDisputed) {
			this.isDisputed = isDisputed==null?null:isDisputed;
			return this;
		}
		
		@Override
		public PartyTradeInformation build() {
			return new PartyTradeInformation.PartyTradeInformationImpl(this);
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder prune() {
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			unit = unit.stream().filter(b->b!=null).<Unit.UnitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			relatedBusinessUnit = relatedBusinessUnit.stream().filter(b->b!=null).<RelatedBusinessUnit.RelatedBusinessUnitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			relatedPerson = relatedPerson.stream().filter(b->b!=null).<RelatedPerson.RelatedPersonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			algorithm = algorithm.stream().filter(b->b!=null).<Algorithm.AlgorithmBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			category = category.stream().filter(b->b!=null).<TradeCategory.TradeCategoryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			trader = trader.stream().filter(b->b!=null).<Trader.TraderBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			if (timestamps!=null && !timestamps.prune().hasData()) timestamps = null;
			if (allocationStatus!=null && !allocationStatus.prune().hasData()) allocationStatus = null;
			if (clearingStatus!=null && !clearingStatus.prune().hasData()) clearingStatus = null;
			if (collateralizationType!=null && !collateralizationType.prune().hasData()) collateralizationType = null;
			if (collateralPortfolio!=null && !collateralPortfolio.prune().hasData()) collateralPortfolio = null;
			reportingRegime = reportingRegime.stream().filter(b->b!=null).<ReportingRegime.ReportingRegimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyTradeInformationSequence!=null && !partyTradeInformationSequence.prune().hasData()) partyTradeInformationSequence = null;
			if (endUserExceptionDeclaration!=null && !endUserExceptionDeclaration.prune().hasData()) endUserExceptionDeclaration = null;
			pricingContext = pricingContext.stream().filter(b->b!=null).<PricingContext.PricingContextBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionType!=null && !executionType.prune().hasData()) executionType = null;
			if (executionVenueType!=null && !executionVenueType.prune().hasData()) executionVenueType = null;
			if (verificationMethod!=null && !verificationMethod.prune().hasData()) verificationMethod = null;
			if (confirmationMethod!=null && !confirmationMethod.prune().hasData()) confirmationMethod = null;
			if (transactionClassificationModel!=null && !transactionClassificationModel.prune().hasData()) transactionClassificationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getUnit()!=null && getUnit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRelatedBusinessUnit()!=null && getRelatedBusinessUnit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRelatedPerson()!=null && getRelatedPerson().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAlgorithm()!=null && getAlgorithm().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIsAccountingHedge()!=null) return true;
			if (getCategory()!=null && getCategory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTrader()!=null && getTrader().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getTimestamps()!=null && getTimestamps().hasData()) return true;
			if (getIntentToAllocate()!=null) return true;
			if (getAllocationStatus()!=null && getAllocationStatus().hasData()) return true;
			if (getIntentToClear()!=null) return true;
			if (getClearingStatus()!=null && getClearingStatus().hasData()) return true;
			if (getCollateralizationType()!=null && getCollateralizationType().hasData()) return true;
			if (getCollateralPortfolio()!=null && getCollateralPortfolio().hasData()) return true;
			if (getReportingRegime()!=null && getReportingRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeInformationSequence()!=null && getPartyTradeInformationSequence().hasData()) return true;
			if (getEndUserExceptionDeclaration()!=null && getEndUserExceptionDeclaration().hasData()) return true;
			if (getNonStandardTerms()!=null) return true;
			if (getOffMarketPrice()!=null) return true;
			if (getPricingContext()!=null && getPricingContext().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLargeSizeTrade()!=null) return true;
			if (getExecutionType()!=null && getExecutionType().hasData()) return true;
			if (getExecutionVenueType()!=null && getExecutionVenueType().hasData()) return true;
			if (getVerificationMethod()!=null && getVerificationMethod().hasData()) return true;
			if (getConfirmationMethod()!=null && getConfirmationMethod().hasData()) return true;
			if (getCompressedTrade()!=null) return true;
			if (getTransactionClassificationModel()!=null && getTransactionClassificationModel().hasData()) return true;
			if (getIsDisputed()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyTradeInformation.PartyTradeInformationBuilder o = (PartyTradeInformation.PartyTradeInformationBuilder) other;
			
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getUnit(), o.getUnit(), this::getOrCreateUnit);
			merger.mergeRosetta(getRelatedBusinessUnit(), o.getRelatedBusinessUnit(), this::getOrCreateRelatedBusinessUnit);
			merger.mergeRosetta(getRelatedPerson(), o.getRelatedPerson(), this::getOrCreateRelatedPerson);
			merger.mergeRosetta(getAlgorithm(), o.getAlgorithm(), this::getOrCreateAlgorithm);
			merger.mergeRosetta(getCategory(), o.getCategory(), this::getOrCreateCategory);
			merger.mergeRosetta(getTrader(), o.getTrader(), this::getOrCreateTrader);
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			merger.mergeRosetta(getTimestamps(), o.getTimestamps(), this::setTimestamps);
			merger.mergeRosetta(getAllocationStatus(), o.getAllocationStatus(), this::setAllocationStatus);
			merger.mergeRosetta(getClearingStatus(), o.getClearingStatus(), this::setClearingStatus);
			merger.mergeRosetta(getCollateralizationType(), o.getCollateralizationType(), this::setCollateralizationType);
			merger.mergeRosetta(getCollateralPortfolio(), o.getCollateralPortfolio(), this::setCollateralPortfolio);
			merger.mergeRosetta(getReportingRegime(), o.getReportingRegime(), this::getOrCreateReportingRegime);
			merger.mergeRosetta(getPartyTradeInformationSequence(), o.getPartyTradeInformationSequence(), this::setPartyTradeInformationSequence);
			merger.mergeRosetta(getEndUserExceptionDeclaration(), o.getEndUserExceptionDeclaration(), this::setEndUserExceptionDeclaration);
			merger.mergeRosetta(getPricingContext(), o.getPricingContext(), this::getOrCreatePricingContext);
			merger.mergeRosetta(getExecutionType(), o.getExecutionType(), this::setExecutionType);
			merger.mergeRosetta(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			merger.mergeRosetta(getVerificationMethod(), o.getVerificationMethod(), this::setVerificationMethod);
			merger.mergeRosetta(getConfirmationMethod(), o.getConfirmationMethod(), this::setConfirmationMethod);
			merger.mergeRosetta(getTransactionClassificationModel(), o.getTransactionClassificationModel(), this::setTransactionClassificationModel);
			
			merger.mergeBasic(getIsAccountingHedge(), o.getIsAccountingHedge(), this::setIsAccountingHedge);
			merger.mergeBasic(getIntentToAllocate(), o.getIntentToAllocate(), this::setIntentToAllocate);
			merger.mergeBasic(getIntentToClear(), o.getIntentToClear(), this::setIntentToClear);
			merger.mergeBasic(getNonStandardTerms(), o.getNonStandardTerms(), this::setNonStandardTerms);
			merger.mergeBasic(getOffMarketPrice(), o.getOffMarketPrice(), this::setOffMarketPrice);
			merger.mergeBasic(getLargeSizeTrade(), o.getLargeSizeTrade(), this::setLargeSizeTrade);
			merger.mergeBasic(getCompressedTrade(), o.getCompressedTrade(), this::setCompressedTrade);
			merger.mergeBasic(getIsDisputed(), o.getIsDisputed(), this::setIsDisputed);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(unit, _that.getUnit())) return false;
			if (!ListEquals.listEquals(relatedBusinessUnit, _that.getRelatedBusinessUnit())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!ListEquals.listEquals(algorithm, _that.getAlgorithm())) return false;
			if (!Objects.equals(isAccountingHedge, _that.getIsAccountingHedge())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!ListEquals.listEquals(trader, _that.getTrader())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(timestamps, _that.getTimestamps())) return false;
			if (!Objects.equals(intentToAllocate, _that.getIntentToAllocate())) return false;
			if (!Objects.equals(allocationStatus, _that.getAllocationStatus())) return false;
			if (!Objects.equals(intentToClear, _that.getIntentToClear())) return false;
			if (!Objects.equals(clearingStatus, _that.getClearingStatus())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(collateralPortfolio, _that.getCollateralPortfolio())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			if (!Objects.equals(partyTradeInformationSequence, _that.getPartyTradeInformationSequence())) return false;
			if (!Objects.equals(endUserExceptionDeclaration, _that.getEndUserExceptionDeclaration())) return false;
			if (!Objects.equals(nonStandardTerms, _that.getNonStandardTerms())) return false;
			if (!Objects.equals(offMarketPrice, _that.getOffMarketPrice())) return false;
			if (!ListEquals.listEquals(pricingContext, _that.getPricingContext())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(executionType, _that.getExecutionType())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(verificationMethod, _that.getVerificationMethod())) return false;
			if (!Objects.equals(confirmationMethod, _that.getConfirmationMethod())) return false;
			if (!Objects.equals(compressedTrade, _that.getCompressedTrade())) return false;
			if (!Objects.equals(transactionClassificationModel, _that.getTransactionClassificationModel())) return false;
			if (!Objects.equals(isDisputed, _that.getIsDisputed())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (relatedBusinessUnit != null ? relatedBusinessUnit.hashCode() : 0);
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (isAccountingHedge != null ? isAccountingHedge.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (trader != null ? trader.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (timestamps != null ? timestamps.hashCode() : 0);
			_result = 31 * _result + (intentToAllocate != null ? intentToAllocate.hashCode() : 0);
			_result = 31 * _result + (allocationStatus != null ? allocationStatus.hashCode() : 0);
			_result = 31 * _result + (intentToClear != null ? intentToClear.hashCode() : 0);
			_result = 31 * _result + (clearingStatus != null ? clearingStatus.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolio != null ? collateralPortfolio.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformationSequence != null ? partyTradeInformationSequence.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionDeclaration != null ? endUserExceptionDeclaration.hashCode() : 0);
			_result = 31 * _result + (nonStandardTerms != null ? nonStandardTerms.hashCode() : 0);
			_result = 31 * _result + (offMarketPrice != null ? offMarketPrice.hashCode() : 0);
			_result = 31 * _result + (pricingContext != null ? pricingContext.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (executionType != null ? executionType.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (verificationMethod != null ? verificationMethod.hashCode() : 0);
			_result = 31 * _result + (confirmationMethod != null ? confirmationMethod.hashCode() : 0);
			_result = 31 * _result + (compressedTrade != null ? compressedTrade.hashCode() : 0);
			_result = 31 * _result + (transactionClassificationModel != null ? transactionClassificationModel.hashCode() : 0);
			_result = 31 * _result + (isDisputed != null ? isDisputed.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeInformationBuilder {" +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"unit=" + this.unit + ", " +
				"relatedBusinessUnit=" + this.relatedBusinessUnit + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"algorithm=" + this.algorithm + ", " +
				"isAccountingHedge=" + this.isAccountingHedge + ", " +
				"category=" + this.category + ", " +
				"trader=" + this.trader + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"timestamps=" + this.timestamps + ", " +
				"intentToAllocate=" + this.intentToAllocate + ", " +
				"allocationStatus=" + this.allocationStatus + ", " +
				"intentToClear=" + this.intentToClear + ", " +
				"clearingStatus=" + this.clearingStatus + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"collateralPortfolio=" + this.collateralPortfolio + ", " +
				"reportingRegime=" + this.reportingRegime + ", " +
				"partyTradeInformationSequence=" + this.partyTradeInformationSequence + ", " +
				"endUserExceptionDeclaration=" + this.endUserExceptionDeclaration + ", " +
				"nonStandardTerms=" + this.nonStandardTerms + ", " +
				"offMarketPrice=" + this.offMarketPrice + ", " +
				"pricingContext=" + this.pricingContext + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"executionType=" + this.executionType + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"verificationMethod=" + this.verificationMethod + ", " +
				"confirmationMethod=" + this.confirmationMethod + ", " +
				"compressedTrade=" + this.compressedTrade + ", " +
				"transactionClassificationModel=" + this.transactionClassificationModel + ", " +
				"isDisputed=" + this.isDisputed +
			'}';
		}
	}
}
