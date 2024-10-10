package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel;
import fpml.confirmation.DividendAmountTypeEnum;
import fpml.confirmation.DividendCompositionEnum;
import fpml.confirmation.DividendConditions;
import fpml.confirmation.DividendConditions.DividendConditionsBuilder;
import fpml.confirmation.DividendConditions.DividendConditionsBuilderImpl;
import fpml.confirmation.DividendConditions.DividendConditionsImpl;
import fpml.confirmation.DividendConditionsSequence;
import fpml.confirmation.DividendEntitlementEnum;
import fpml.confirmation.DividendPaymentDate;
import fpml.confirmation.DividendPeriodEnum;
import fpml.confirmation.InterestAccrualsCompoundingMethod;
import fpml.confirmation.NonCashDividendTreatmentEnum;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.DividendConditionsMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the conditions governing the payment of dividends to the receiver of the equity return. With the exception of the dividend payout ratio, which is defined for each of the underlying components.
 * @version ${project.version}
 */
@RosettaDataType(value="DividendConditions", builder=DividendConditions.DividendConditionsBuilderImpl.class, version="${project.version}")
public interface DividendConditions extends RosettaModelObject {

	DividendConditionsMeta metaData = new DividendConditionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Boolean element that defines whether the dividend will be reinvested or not.
	 */
	Boolean getDividendReinvestment();
	/**
	 * Defines the date on which the receiver on the equity return is entitled to the dividend.
	 */
	DividendEntitlementEnum getDividendEntitlement();
	DividendAmountTypeEnum getDividendAmount();
	/**
	 * Specifies when the dividend will be paid to the receiver of the equity return. Has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Is not applicable in the case of a dividend reinvestment election.
	 */
	DividendPaymentDate getDividendPaymentDate();
	DividendConditionsSequence getDividendConditionsSequence();
	/**
	 * Defines the First Period or the Second Period, as defined in the 2002 ISDA Equity Derivatives Definitions.
	 */
	DividendPeriodEnum getDividendPeriod();
	/**
	 * Reference to the party which determines if dividends are extraordinary in relation to normal levels.
	 */
	PartyReference getExtraOrdinaryDividends();
	/**
	 * Determination of Gross Cash Dividend per Share.
	 */
	DividendAmountTypeEnum getExcessDividendAmount();
	CurrencyAndDeterminationMethodModel getCurrencyAndDeterminationMethodModel();
	/**
	 * Specifies the date on which the FX rate will be considered in the case of a Composite FX swap.
	 */
	DividendPaymentDate getDividendFxTriggerDate();
	/**
	 * Defines the way in which interests are accrued: the applicable rate (fixed or floating reference) and the compounding method. FpML entity
	 */
	InterestAccrualsCompoundingMethod getInterestAccrualsMethod();
	/**
	 * Defines the Number Of Index Units applicable to a Dividend.
	 */
	BigDecimal getNumberOfIndexUnits();
	DeclaredCashAndCashEquivalentDividendPercentageModel getDeclaredCashAndCashEquivalentDividendPercentageModel();
	/**
	 * Defines treatment of Non-Cash Dividends.
	 */
	NonCashDividendTreatmentEnum getNonCashDividendTreatment();
	/**
	 * Defines how the composition of Dividends is to be determined.
	 */
	DividendCompositionEnum getDividendComposition();
	/**
	 * Specifies the method according to which special dividends are determined.
	 */
	Boolean getSpecialDividends();

	/*********************** Build Methods  ***********************/
	DividendConditions build();
	
	DividendConditions.DividendConditionsBuilder toBuilder();
	
	static DividendConditions.DividendConditionsBuilder builder() {
		return new DividendConditions.DividendConditionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendConditions> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendConditions> getType() {
		return DividendConditions.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendReinvestment"), Boolean.class, getDividendReinvestment(), this);
		processor.processBasic(path.newSubPath("dividendEntitlement"), DividendEntitlementEnum.class, getDividendEntitlement(), this);
		processor.processBasic(path.newSubPath("dividendAmount"), DividendAmountTypeEnum.class, getDividendAmount(), this);
		processRosetta(path.newSubPath("dividendPaymentDate"), processor, DividendPaymentDate.class, getDividendPaymentDate());
		processRosetta(path.newSubPath("dividendConditionsSequence"), processor, DividendConditionsSequence.class, getDividendConditionsSequence());
		processor.processBasic(path.newSubPath("dividendPeriod"), DividendPeriodEnum.class, getDividendPeriod(), this);
		processRosetta(path.newSubPath("extraOrdinaryDividends"), processor, PartyReference.class, getExtraOrdinaryDividends());
		processor.processBasic(path.newSubPath("excessDividendAmount"), DividendAmountTypeEnum.class, getExcessDividendAmount(), this);
		processRosetta(path.newSubPath("currencyAndDeterminationMethodModel"), processor, CurrencyAndDeterminationMethodModel.class, getCurrencyAndDeterminationMethodModel());
		processRosetta(path.newSubPath("dividendFxTriggerDate"), processor, DividendPaymentDate.class, getDividendFxTriggerDate());
		processRosetta(path.newSubPath("interestAccrualsMethod"), processor, InterestAccrualsCompoundingMethod.class, getInterestAccrualsMethod());
		processor.processBasic(path.newSubPath("numberOfIndexUnits"), BigDecimal.class, getNumberOfIndexUnits(), this);
		processRosetta(path.newSubPath("declaredCashAndCashEquivalentDividendPercentageModel"), processor, DeclaredCashAndCashEquivalentDividendPercentageModel.class, getDeclaredCashAndCashEquivalentDividendPercentageModel());
		processor.processBasic(path.newSubPath("nonCashDividendTreatment"), NonCashDividendTreatmentEnum.class, getNonCashDividendTreatment(), this);
		processor.processBasic(path.newSubPath("dividendComposition"), DividendCompositionEnum.class, getDividendComposition(), this);
		processor.processBasic(path.newSubPath("specialDividends"), Boolean.class, getSpecialDividends(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendConditionsBuilder extends DividendConditions, RosettaModelObjectBuilder {
		DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendPaymentDate();
		DividendPaymentDate.DividendPaymentDateBuilder getDividendPaymentDate();
		DividendConditionsSequence.DividendConditionsSequenceBuilder getOrCreateDividendConditionsSequence();
		DividendConditionsSequence.DividendConditionsSequenceBuilder getDividendConditionsSequence();
		PartyReference.PartyReferenceBuilder getOrCreateExtraOrdinaryDividends();
		PartyReference.PartyReferenceBuilder getExtraOrdinaryDividends();
		CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder getOrCreateCurrencyAndDeterminationMethodModel();
		CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder getCurrencyAndDeterminationMethodModel();
		DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendFxTriggerDate();
		DividendPaymentDate.DividendPaymentDateBuilder getDividendFxTriggerDate();
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder getOrCreateInterestAccrualsMethod();
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder getInterestAccrualsMethod();
		DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder getOrCreateDeclaredCashAndCashEquivalentDividendPercentageModel();
		DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder getDeclaredCashAndCashEquivalentDividendPercentageModel();
		DividendConditions.DividendConditionsBuilder setDividendReinvestment(Boolean dividendReinvestment);
		DividendConditions.DividendConditionsBuilder setDividendEntitlement(DividendEntitlementEnum dividendEntitlement);
		DividendConditions.DividendConditionsBuilder setDividendAmount(DividendAmountTypeEnum dividendAmount);
		DividendConditions.DividendConditionsBuilder setDividendPaymentDate(DividendPaymentDate dividendPaymentDate);
		DividendConditions.DividendConditionsBuilder setDividendConditionsSequence(DividendConditionsSequence dividendConditionsSequence);
		DividendConditions.DividendConditionsBuilder setDividendPeriod(DividendPeriodEnum dividendPeriod);
		DividendConditions.DividendConditionsBuilder setExtraOrdinaryDividends(PartyReference extraOrdinaryDividends);
		DividendConditions.DividendConditionsBuilder setExcessDividendAmount(DividendAmountTypeEnum excessDividendAmount);
		DividendConditions.DividendConditionsBuilder setCurrencyAndDeterminationMethodModel(CurrencyAndDeterminationMethodModel currencyAndDeterminationMethodModel);
		DividendConditions.DividendConditionsBuilder setDividendFxTriggerDate(DividendPaymentDate dividendFxTriggerDate);
		DividendConditions.DividendConditionsBuilder setInterestAccrualsMethod(InterestAccrualsCompoundingMethod interestAccrualsMethod);
		DividendConditions.DividendConditionsBuilder setNumberOfIndexUnits(BigDecimal numberOfIndexUnits);
		DividendConditions.DividendConditionsBuilder setDeclaredCashAndCashEquivalentDividendPercentageModel(DeclaredCashAndCashEquivalentDividendPercentageModel declaredCashAndCashEquivalentDividendPercentageModel);
		DividendConditions.DividendConditionsBuilder setNonCashDividendTreatment(NonCashDividendTreatmentEnum nonCashDividendTreatment);
		DividendConditions.DividendConditionsBuilder setDividendComposition(DividendCompositionEnum dividendComposition);
		DividendConditions.DividendConditionsBuilder setSpecialDividends(Boolean specialDividends);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dividendReinvestment"), Boolean.class, getDividendReinvestment(), this);
			processor.processBasic(path.newSubPath("dividendEntitlement"), DividendEntitlementEnum.class, getDividendEntitlement(), this);
			processor.processBasic(path.newSubPath("dividendAmount"), DividendAmountTypeEnum.class, getDividendAmount(), this);
			processRosetta(path.newSubPath("dividendPaymentDate"), processor, DividendPaymentDate.DividendPaymentDateBuilder.class, getDividendPaymentDate());
			processRosetta(path.newSubPath("dividendConditionsSequence"), processor, DividendConditionsSequence.DividendConditionsSequenceBuilder.class, getDividendConditionsSequence());
			processor.processBasic(path.newSubPath("dividendPeriod"), DividendPeriodEnum.class, getDividendPeriod(), this);
			processRosetta(path.newSubPath("extraOrdinaryDividends"), processor, PartyReference.PartyReferenceBuilder.class, getExtraOrdinaryDividends());
			processor.processBasic(path.newSubPath("excessDividendAmount"), DividendAmountTypeEnum.class, getExcessDividendAmount(), this);
			processRosetta(path.newSubPath("currencyAndDeterminationMethodModel"), processor, CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder.class, getCurrencyAndDeterminationMethodModel());
			processRosetta(path.newSubPath("dividendFxTriggerDate"), processor, DividendPaymentDate.DividendPaymentDateBuilder.class, getDividendFxTriggerDate());
			processRosetta(path.newSubPath("interestAccrualsMethod"), processor, InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder.class, getInterestAccrualsMethod());
			processor.processBasic(path.newSubPath("numberOfIndexUnits"), BigDecimal.class, getNumberOfIndexUnits(), this);
			processRosetta(path.newSubPath("declaredCashAndCashEquivalentDividendPercentageModel"), processor, DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder.class, getDeclaredCashAndCashEquivalentDividendPercentageModel());
			processor.processBasic(path.newSubPath("nonCashDividendTreatment"), NonCashDividendTreatmentEnum.class, getNonCashDividendTreatment(), this);
			processor.processBasic(path.newSubPath("dividendComposition"), DividendCompositionEnum.class, getDividendComposition(), this);
			processor.processBasic(path.newSubPath("specialDividends"), Boolean.class, getSpecialDividends(), this);
		}
		

		DividendConditions.DividendConditionsBuilder prune();
	}

	/*********************** Immutable Implementation of DividendConditions  ***********************/
	class DividendConditionsImpl implements DividendConditions {
		private final Boolean dividendReinvestment;
		private final DividendEntitlementEnum dividendEntitlement;
		private final DividendAmountTypeEnum dividendAmount;
		private final DividendPaymentDate dividendPaymentDate;
		private final DividendConditionsSequence dividendConditionsSequence;
		private final DividendPeriodEnum dividendPeriod;
		private final PartyReference extraOrdinaryDividends;
		private final DividendAmountTypeEnum excessDividendAmount;
		private final CurrencyAndDeterminationMethodModel currencyAndDeterminationMethodModel;
		private final DividendPaymentDate dividendFxTriggerDate;
		private final InterestAccrualsCompoundingMethod interestAccrualsMethod;
		private final BigDecimal numberOfIndexUnits;
		private final DeclaredCashAndCashEquivalentDividendPercentageModel declaredCashAndCashEquivalentDividendPercentageModel;
		private final NonCashDividendTreatmentEnum nonCashDividendTreatment;
		private final DividendCompositionEnum dividendComposition;
		private final Boolean specialDividends;
		
		protected DividendConditionsImpl(DividendConditions.DividendConditionsBuilder builder) {
			this.dividendReinvestment = builder.getDividendReinvestment();
			this.dividendEntitlement = builder.getDividendEntitlement();
			this.dividendAmount = builder.getDividendAmount();
			this.dividendPaymentDate = ofNullable(builder.getDividendPaymentDate()).map(f->f.build()).orElse(null);
			this.dividendConditionsSequence = ofNullable(builder.getDividendConditionsSequence()).map(f->f.build()).orElse(null);
			this.dividendPeriod = builder.getDividendPeriod();
			this.extraOrdinaryDividends = ofNullable(builder.getExtraOrdinaryDividends()).map(f->f.build()).orElse(null);
			this.excessDividendAmount = builder.getExcessDividendAmount();
			this.currencyAndDeterminationMethodModel = ofNullable(builder.getCurrencyAndDeterminationMethodModel()).map(f->f.build()).orElse(null);
			this.dividendFxTriggerDate = ofNullable(builder.getDividendFxTriggerDate()).map(f->f.build()).orElse(null);
			this.interestAccrualsMethod = ofNullable(builder.getInterestAccrualsMethod()).map(f->f.build()).orElse(null);
			this.numberOfIndexUnits = builder.getNumberOfIndexUnits();
			this.declaredCashAndCashEquivalentDividendPercentageModel = ofNullable(builder.getDeclaredCashAndCashEquivalentDividendPercentageModel()).map(f->f.build()).orElse(null);
			this.nonCashDividendTreatment = builder.getNonCashDividendTreatment();
			this.dividendComposition = builder.getDividendComposition();
			this.specialDividends = builder.getSpecialDividends();
		}
		
		@Override
		@RosettaAttribute("dividendReinvestment")
		public Boolean getDividendReinvestment() {
			return dividendReinvestment;
		}
		
		@Override
		@RosettaAttribute("dividendEntitlement")
		public DividendEntitlementEnum getDividendEntitlement() {
			return dividendEntitlement;
		}
		
		@Override
		@RosettaAttribute("dividendAmount")
		public DividendAmountTypeEnum getDividendAmount() {
			return dividendAmount;
		}
		
		@Override
		@RosettaAttribute("dividendPaymentDate")
		public DividendPaymentDate getDividendPaymentDate() {
			return dividendPaymentDate;
		}
		
		@Override
		@RosettaAttribute("dividendConditionsSequence")
		public DividendConditionsSequence getDividendConditionsSequence() {
			return dividendConditionsSequence;
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		public DividendPeriodEnum getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		@RosettaAttribute("extraOrdinaryDividends")
		public PartyReference getExtraOrdinaryDividends() {
			return extraOrdinaryDividends;
		}
		
		@Override
		@RosettaAttribute("excessDividendAmount")
		public DividendAmountTypeEnum getExcessDividendAmount() {
			return excessDividendAmount;
		}
		
		@Override
		@RosettaAttribute("currencyAndDeterminationMethodModel")
		public CurrencyAndDeterminationMethodModel getCurrencyAndDeterminationMethodModel() {
			return currencyAndDeterminationMethodModel;
		}
		
		@Override
		@RosettaAttribute("dividendFxTriggerDate")
		public DividendPaymentDate getDividendFxTriggerDate() {
			return dividendFxTriggerDate;
		}
		
		@Override
		@RosettaAttribute("interestAccrualsMethod")
		public InterestAccrualsCompoundingMethod getInterestAccrualsMethod() {
			return interestAccrualsMethod;
		}
		
		@Override
		@RosettaAttribute("numberOfIndexUnits")
		public BigDecimal getNumberOfIndexUnits() {
			return numberOfIndexUnits;
		}
		
		@Override
		@RosettaAttribute("declaredCashAndCashEquivalentDividendPercentageModel")
		public DeclaredCashAndCashEquivalentDividendPercentageModel getDeclaredCashAndCashEquivalentDividendPercentageModel() {
			return declaredCashAndCashEquivalentDividendPercentageModel;
		}
		
		@Override
		@RosettaAttribute("nonCashDividendTreatment")
		public NonCashDividendTreatmentEnum getNonCashDividendTreatment() {
			return nonCashDividendTreatment;
		}
		
		@Override
		@RosettaAttribute("dividendComposition")
		public DividendCompositionEnum getDividendComposition() {
			return dividendComposition;
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		public Boolean getSpecialDividends() {
			return specialDividends;
		}
		
		@Override
		public DividendConditions build() {
			return this;
		}
		
		@Override
		public DividendConditions.DividendConditionsBuilder toBuilder() {
			DividendConditions.DividendConditionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendConditions.DividendConditionsBuilder builder) {
			ofNullable(getDividendReinvestment()).ifPresent(builder::setDividendReinvestment);
			ofNullable(getDividendEntitlement()).ifPresent(builder::setDividendEntitlement);
			ofNullable(getDividendAmount()).ifPresent(builder::setDividendAmount);
			ofNullable(getDividendPaymentDate()).ifPresent(builder::setDividendPaymentDate);
			ofNullable(getDividendConditionsSequence()).ifPresent(builder::setDividendConditionsSequence);
			ofNullable(getDividendPeriod()).ifPresent(builder::setDividendPeriod);
			ofNullable(getExtraOrdinaryDividends()).ifPresent(builder::setExtraOrdinaryDividends);
			ofNullable(getExcessDividendAmount()).ifPresent(builder::setExcessDividendAmount);
			ofNullable(getCurrencyAndDeterminationMethodModel()).ifPresent(builder::setCurrencyAndDeterminationMethodModel);
			ofNullable(getDividendFxTriggerDate()).ifPresent(builder::setDividendFxTriggerDate);
			ofNullable(getInterestAccrualsMethod()).ifPresent(builder::setInterestAccrualsMethod);
			ofNullable(getNumberOfIndexUnits()).ifPresent(builder::setNumberOfIndexUnits);
			ofNullable(getDeclaredCashAndCashEquivalentDividendPercentageModel()).ifPresent(builder::setDeclaredCashAndCashEquivalentDividendPercentageModel);
			ofNullable(getNonCashDividendTreatment()).ifPresent(builder::setNonCashDividendTreatment);
			ofNullable(getDividendComposition()).ifPresent(builder::setDividendComposition);
			ofNullable(getSpecialDividends()).ifPresent(builder::setSpecialDividends);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendConditions _that = getType().cast(o);
		
			if (!Objects.equals(dividendReinvestment, _that.getDividendReinvestment())) return false;
			if (!Objects.equals(dividendEntitlement, _that.getDividendEntitlement())) return false;
			if (!Objects.equals(dividendAmount, _that.getDividendAmount())) return false;
			if (!Objects.equals(dividendPaymentDate, _that.getDividendPaymentDate())) return false;
			if (!Objects.equals(dividendConditionsSequence, _that.getDividendConditionsSequence())) return false;
			if (!Objects.equals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(extraOrdinaryDividends, _that.getExtraOrdinaryDividends())) return false;
			if (!Objects.equals(excessDividendAmount, _that.getExcessDividendAmount())) return false;
			if (!Objects.equals(currencyAndDeterminationMethodModel, _that.getCurrencyAndDeterminationMethodModel())) return false;
			if (!Objects.equals(dividendFxTriggerDate, _that.getDividendFxTriggerDate())) return false;
			if (!Objects.equals(interestAccrualsMethod, _that.getInterestAccrualsMethod())) return false;
			if (!Objects.equals(numberOfIndexUnits, _that.getNumberOfIndexUnits())) return false;
			if (!Objects.equals(declaredCashAndCashEquivalentDividendPercentageModel, _that.getDeclaredCashAndCashEquivalentDividendPercentageModel())) return false;
			if (!Objects.equals(nonCashDividendTreatment, _that.getNonCashDividendTreatment())) return false;
			if (!Objects.equals(dividendComposition, _that.getDividendComposition())) return false;
			if (!Objects.equals(specialDividends, _that.getSpecialDividends())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendReinvestment != null ? dividendReinvestment.hashCode() : 0);
			_result = 31 * _result + (dividendEntitlement != null ? dividendEntitlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendAmount != null ? dividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendPaymentDate != null ? dividendPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dividendConditionsSequence != null ? dividendConditionsSequence.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraOrdinaryDividends != null ? extraOrdinaryDividends.hashCode() : 0);
			_result = 31 * _result + (excessDividendAmount != null ? excessDividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currencyAndDeterminationMethodModel != null ? currencyAndDeterminationMethodModel.hashCode() : 0);
			_result = 31 * _result + (dividendFxTriggerDate != null ? dividendFxTriggerDate.hashCode() : 0);
			_result = 31 * _result + (interestAccrualsMethod != null ? interestAccrualsMethod.hashCode() : 0);
			_result = 31 * _result + (numberOfIndexUnits != null ? numberOfIndexUnits.hashCode() : 0);
			_result = 31 * _result + (declaredCashAndCashEquivalentDividendPercentageModel != null ? declaredCashAndCashEquivalentDividendPercentageModel.hashCode() : 0);
			_result = 31 * _result + (nonCashDividendTreatment != null ? nonCashDividendTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendComposition != null ? dividendComposition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specialDividends != null ? specialDividends.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendConditions {" +
				"dividendReinvestment=" + this.dividendReinvestment + ", " +
				"dividendEntitlement=" + this.dividendEntitlement + ", " +
				"dividendAmount=" + this.dividendAmount + ", " +
				"dividendPaymentDate=" + this.dividendPaymentDate + ", " +
				"dividendConditionsSequence=" + this.dividendConditionsSequence + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"extraOrdinaryDividends=" + this.extraOrdinaryDividends + ", " +
				"excessDividendAmount=" + this.excessDividendAmount + ", " +
				"currencyAndDeterminationMethodModel=" + this.currencyAndDeterminationMethodModel + ", " +
				"dividendFxTriggerDate=" + this.dividendFxTriggerDate + ", " +
				"interestAccrualsMethod=" + this.interestAccrualsMethod + ", " +
				"numberOfIndexUnits=" + this.numberOfIndexUnits + ", " +
				"declaredCashAndCashEquivalentDividendPercentageModel=" + this.declaredCashAndCashEquivalentDividendPercentageModel + ", " +
				"nonCashDividendTreatment=" + this.nonCashDividendTreatment + ", " +
				"dividendComposition=" + this.dividendComposition + ", " +
				"specialDividends=" + this.specialDividends +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendConditions  ***********************/
	class DividendConditionsBuilderImpl implements DividendConditions.DividendConditionsBuilder {
	
		protected Boolean dividendReinvestment;
		protected DividendEntitlementEnum dividendEntitlement;
		protected DividendAmountTypeEnum dividendAmount;
		protected DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate;
		protected DividendConditionsSequence.DividendConditionsSequenceBuilder dividendConditionsSequence;
		protected DividendPeriodEnum dividendPeriod;
		protected PartyReference.PartyReferenceBuilder extraOrdinaryDividends;
		protected DividendAmountTypeEnum excessDividendAmount;
		protected CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder currencyAndDeterminationMethodModel;
		protected DividendPaymentDate.DividendPaymentDateBuilder dividendFxTriggerDate;
		protected InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder interestAccrualsMethod;
		protected BigDecimal numberOfIndexUnits;
		protected DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder declaredCashAndCashEquivalentDividendPercentageModel;
		protected NonCashDividendTreatmentEnum nonCashDividendTreatment;
		protected DividendCompositionEnum dividendComposition;
		protected Boolean specialDividends;
	
		public DividendConditionsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendReinvestment")
		public Boolean getDividendReinvestment() {
			return dividendReinvestment;
		}
		
		@Override
		@RosettaAttribute("dividendEntitlement")
		public DividendEntitlementEnum getDividendEntitlement() {
			return dividendEntitlement;
		}
		
		@Override
		@RosettaAttribute("dividendAmount")
		public DividendAmountTypeEnum getDividendAmount() {
			return dividendAmount;
		}
		
		@Override
		@RosettaAttribute("dividendPaymentDate")
		public DividendPaymentDate.DividendPaymentDateBuilder getDividendPaymentDate() {
			return dividendPaymentDate;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendPaymentDate() {
			DividendPaymentDate.DividendPaymentDateBuilder result;
			if (dividendPaymentDate!=null) {
				result = dividendPaymentDate;
			}
			else {
				result = dividendPaymentDate = DividendPaymentDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendConditionsSequence")
		public DividendConditionsSequence.DividendConditionsSequenceBuilder getDividendConditionsSequence() {
			return dividendConditionsSequence;
		}
		
		@Override
		public DividendConditionsSequence.DividendConditionsSequenceBuilder getOrCreateDividendConditionsSequence() {
			DividendConditionsSequence.DividendConditionsSequenceBuilder result;
			if (dividendConditionsSequence!=null) {
				result = dividendConditionsSequence;
			}
			else {
				result = dividendConditionsSequence = DividendConditionsSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		public DividendPeriodEnum getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		@RosettaAttribute("extraOrdinaryDividends")
		public PartyReference.PartyReferenceBuilder getExtraOrdinaryDividends() {
			return extraOrdinaryDividends;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateExtraOrdinaryDividends() {
			PartyReference.PartyReferenceBuilder result;
			if (extraOrdinaryDividends!=null) {
				result = extraOrdinaryDividends;
			}
			else {
				result = extraOrdinaryDividends = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("excessDividendAmount")
		public DividendAmountTypeEnum getExcessDividendAmount() {
			return excessDividendAmount;
		}
		
		@Override
		@RosettaAttribute("currencyAndDeterminationMethodModel")
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder getCurrencyAndDeterminationMethodModel() {
			return currencyAndDeterminationMethodModel;
		}
		
		@Override
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder getOrCreateCurrencyAndDeterminationMethodModel() {
			CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder result;
			if (currencyAndDeterminationMethodModel!=null) {
				result = currencyAndDeterminationMethodModel;
			}
			else {
				result = currencyAndDeterminationMethodModel = CurrencyAndDeterminationMethodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendFxTriggerDate")
		public DividendPaymentDate.DividendPaymentDateBuilder getDividendFxTriggerDate() {
			return dividendFxTriggerDate;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendFxTriggerDate() {
			DividendPaymentDate.DividendPaymentDateBuilder result;
			if (dividendFxTriggerDate!=null) {
				result = dividendFxTriggerDate;
			}
			else {
				result = dividendFxTriggerDate = DividendPaymentDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestAccrualsMethod")
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder getInterestAccrualsMethod() {
			return interestAccrualsMethod;
		}
		
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder getOrCreateInterestAccrualsMethod() {
			InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder result;
			if (interestAccrualsMethod!=null) {
				result = interestAccrualsMethod;
			}
			else {
				result = interestAccrualsMethod = InterestAccrualsCompoundingMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfIndexUnits")
		public BigDecimal getNumberOfIndexUnits() {
			return numberOfIndexUnits;
		}
		
		@Override
		@RosettaAttribute("declaredCashAndCashEquivalentDividendPercentageModel")
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder getDeclaredCashAndCashEquivalentDividendPercentageModel() {
			return declaredCashAndCashEquivalentDividendPercentageModel;
		}
		
		@Override
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder getOrCreateDeclaredCashAndCashEquivalentDividendPercentageModel() {
			DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder result;
			if (declaredCashAndCashEquivalentDividendPercentageModel!=null) {
				result = declaredCashAndCashEquivalentDividendPercentageModel;
			}
			else {
				result = declaredCashAndCashEquivalentDividendPercentageModel = DeclaredCashAndCashEquivalentDividendPercentageModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonCashDividendTreatment")
		public NonCashDividendTreatmentEnum getNonCashDividendTreatment() {
			return nonCashDividendTreatment;
		}
		
		@Override
		@RosettaAttribute("dividendComposition")
		public DividendCompositionEnum getDividendComposition() {
			return dividendComposition;
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		public Boolean getSpecialDividends() {
			return specialDividends;
		}
		
		@Override
		@RosettaAttribute("dividendReinvestment")
		public DividendConditions.DividendConditionsBuilder setDividendReinvestment(Boolean dividendReinvestment) {
			this.dividendReinvestment = dividendReinvestment==null?null:dividendReinvestment;
			return this;
		}
		@Override
		@RosettaAttribute("dividendEntitlement")
		public DividendConditions.DividendConditionsBuilder setDividendEntitlement(DividendEntitlementEnum dividendEntitlement) {
			this.dividendEntitlement = dividendEntitlement==null?null:dividendEntitlement;
			return this;
		}
		@Override
		@RosettaAttribute("dividendAmount")
		public DividendConditions.DividendConditionsBuilder setDividendAmount(DividendAmountTypeEnum dividendAmount) {
			this.dividendAmount = dividendAmount==null?null:dividendAmount;
			return this;
		}
		@Override
		@RosettaAttribute("dividendPaymentDate")
		public DividendConditions.DividendConditionsBuilder setDividendPaymentDate(DividendPaymentDate dividendPaymentDate) {
			this.dividendPaymentDate = dividendPaymentDate==null?null:dividendPaymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendConditionsSequence")
		public DividendConditions.DividendConditionsBuilder setDividendConditionsSequence(DividendConditionsSequence dividendConditionsSequence) {
			this.dividendConditionsSequence = dividendConditionsSequence==null?null:dividendConditionsSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendPeriod")
		public DividendConditions.DividendConditionsBuilder setDividendPeriod(DividendPeriodEnum dividendPeriod) {
			this.dividendPeriod = dividendPeriod==null?null:dividendPeriod;
			return this;
		}
		@Override
		@RosettaAttribute("extraOrdinaryDividends")
		public DividendConditions.DividendConditionsBuilder setExtraOrdinaryDividends(PartyReference extraOrdinaryDividends) {
			this.extraOrdinaryDividends = extraOrdinaryDividends==null?null:extraOrdinaryDividends.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("excessDividendAmount")
		public DividendConditions.DividendConditionsBuilder setExcessDividendAmount(DividendAmountTypeEnum excessDividendAmount) {
			this.excessDividendAmount = excessDividendAmount==null?null:excessDividendAmount;
			return this;
		}
		@Override
		@RosettaAttribute("currencyAndDeterminationMethodModel")
		public DividendConditions.DividendConditionsBuilder setCurrencyAndDeterminationMethodModel(CurrencyAndDeterminationMethodModel currencyAndDeterminationMethodModel) {
			this.currencyAndDeterminationMethodModel = currencyAndDeterminationMethodModel==null?null:currencyAndDeterminationMethodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendFxTriggerDate")
		public DividendConditions.DividendConditionsBuilder setDividendFxTriggerDate(DividendPaymentDate dividendFxTriggerDate) {
			this.dividendFxTriggerDate = dividendFxTriggerDate==null?null:dividendFxTriggerDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestAccrualsMethod")
		public DividendConditions.DividendConditionsBuilder setInterestAccrualsMethod(InterestAccrualsCompoundingMethod interestAccrualsMethod) {
			this.interestAccrualsMethod = interestAccrualsMethod==null?null:interestAccrualsMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("numberOfIndexUnits")
		public DividendConditions.DividendConditionsBuilder setNumberOfIndexUnits(BigDecimal numberOfIndexUnits) {
			this.numberOfIndexUnits = numberOfIndexUnits==null?null:numberOfIndexUnits;
			return this;
		}
		@Override
		@RosettaAttribute("declaredCashAndCashEquivalentDividendPercentageModel")
		public DividendConditions.DividendConditionsBuilder setDeclaredCashAndCashEquivalentDividendPercentageModel(DeclaredCashAndCashEquivalentDividendPercentageModel declaredCashAndCashEquivalentDividendPercentageModel) {
			this.declaredCashAndCashEquivalentDividendPercentageModel = declaredCashAndCashEquivalentDividendPercentageModel==null?null:declaredCashAndCashEquivalentDividendPercentageModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("nonCashDividendTreatment")
		public DividendConditions.DividendConditionsBuilder setNonCashDividendTreatment(NonCashDividendTreatmentEnum nonCashDividendTreatment) {
			this.nonCashDividendTreatment = nonCashDividendTreatment==null?null:nonCashDividendTreatment;
			return this;
		}
		@Override
		@RosettaAttribute("dividendComposition")
		public DividendConditions.DividendConditionsBuilder setDividendComposition(DividendCompositionEnum dividendComposition) {
			this.dividendComposition = dividendComposition==null?null:dividendComposition;
			return this;
		}
		@Override
		@RosettaAttribute("specialDividends")
		public DividendConditions.DividendConditionsBuilder setSpecialDividends(Boolean specialDividends) {
			this.specialDividends = specialDividends==null?null:specialDividends;
			return this;
		}
		
		@Override
		public DividendConditions build() {
			return new DividendConditions.DividendConditionsImpl(this);
		}
		
		@Override
		public DividendConditions.DividendConditionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendConditions.DividendConditionsBuilder prune() {
			if (dividendPaymentDate!=null && !dividendPaymentDate.prune().hasData()) dividendPaymentDate = null;
			if (dividendConditionsSequence!=null && !dividendConditionsSequence.prune().hasData()) dividendConditionsSequence = null;
			if (extraOrdinaryDividends!=null && !extraOrdinaryDividends.prune().hasData()) extraOrdinaryDividends = null;
			if (currencyAndDeterminationMethodModel!=null && !currencyAndDeterminationMethodModel.prune().hasData()) currencyAndDeterminationMethodModel = null;
			if (dividendFxTriggerDate!=null && !dividendFxTriggerDate.prune().hasData()) dividendFxTriggerDate = null;
			if (interestAccrualsMethod!=null && !interestAccrualsMethod.prune().hasData()) interestAccrualsMethod = null;
			if (declaredCashAndCashEquivalentDividendPercentageModel!=null && !declaredCashAndCashEquivalentDividendPercentageModel.prune().hasData()) declaredCashAndCashEquivalentDividendPercentageModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendReinvestment()!=null) return true;
			if (getDividendEntitlement()!=null) return true;
			if (getDividendAmount()!=null) return true;
			if (getDividendPaymentDate()!=null && getDividendPaymentDate().hasData()) return true;
			if (getDividendConditionsSequence()!=null && getDividendConditionsSequence().hasData()) return true;
			if (getDividendPeriod()!=null) return true;
			if (getExtraOrdinaryDividends()!=null && getExtraOrdinaryDividends().hasData()) return true;
			if (getExcessDividendAmount()!=null) return true;
			if (getCurrencyAndDeterminationMethodModel()!=null && getCurrencyAndDeterminationMethodModel().hasData()) return true;
			if (getDividendFxTriggerDate()!=null && getDividendFxTriggerDate().hasData()) return true;
			if (getInterestAccrualsMethod()!=null && getInterestAccrualsMethod().hasData()) return true;
			if (getNumberOfIndexUnits()!=null) return true;
			if (getDeclaredCashAndCashEquivalentDividendPercentageModel()!=null && getDeclaredCashAndCashEquivalentDividendPercentageModel().hasData()) return true;
			if (getNonCashDividendTreatment()!=null) return true;
			if (getDividendComposition()!=null) return true;
			if (getSpecialDividends()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendConditions.DividendConditionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendConditions.DividendConditionsBuilder o = (DividendConditions.DividendConditionsBuilder) other;
			
			merger.mergeRosetta(getDividendPaymentDate(), o.getDividendPaymentDate(), this::setDividendPaymentDate);
			merger.mergeRosetta(getDividendConditionsSequence(), o.getDividendConditionsSequence(), this::setDividendConditionsSequence);
			merger.mergeRosetta(getExtraOrdinaryDividends(), o.getExtraOrdinaryDividends(), this::setExtraOrdinaryDividends);
			merger.mergeRosetta(getCurrencyAndDeterminationMethodModel(), o.getCurrencyAndDeterminationMethodModel(), this::setCurrencyAndDeterminationMethodModel);
			merger.mergeRosetta(getDividendFxTriggerDate(), o.getDividendFxTriggerDate(), this::setDividendFxTriggerDate);
			merger.mergeRosetta(getInterestAccrualsMethod(), o.getInterestAccrualsMethod(), this::setInterestAccrualsMethod);
			merger.mergeRosetta(getDeclaredCashAndCashEquivalentDividendPercentageModel(), o.getDeclaredCashAndCashEquivalentDividendPercentageModel(), this::setDeclaredCashAndCashEquivalentDividendPercentageModel);
			
			merger.mergeBasic(getDividendReinvestment(), o.getDividendReinvestment(), this::setDividendReinvestment);
			merger.mergeBasic(getDividendEntitlement(), o.getDividendEntitlement(), this::setDividendEntitlement);
			merger.mergeBasic(getDividendAmount(), o.getDividendAmount(), this::setDividendAmount);
			merger.mergeBasic(getDividendPeriod(), o.getDividendPeriod(), this::setDividendPeriod);
			merger.mergeBasic(getExcessDividendAmount(), o.getExcessDividendAmount(), this::setExcessDividendAmount);
			merger.mergeBasic(getNumberOfIndexUnits(), o.getNumberOfIndexUnits(), this::setNumberOfIndexUnits);
			merger.mergeBasic(getNonCashDividendTreatment(), o.getNonCashDividendTreatment(), this::setNonCashDividendTreatment);
			merger.mergeBasic(getDividendComposition(), o.getDividendComposition(), this::setDividendComposition);
			merger.mergeBasic(getSpecialDividends(), o.getSpecialDividends(), this::setSpecialDividends);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendConditions _that = getType().cast(o);
		
			if (!Objects.equals(dividendReinvestment, _that.getDividendReinvestment())) return false;
			if (!Objects.equals(dividendEntitlement, _that.getDividendEntitlement())) return false;
			if (!Objects.equals(dividendAmount, _that.getDividendAmount())) return false;
			if (!Objects.equals(dividendPaymentDate, _that.getDividendPaymentDate())) return false;
			if (!Objects.equals(dividendConditionsSequence, _that.getDividendConditionsSequence())) return false;
			if (!Objects.equals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(extraOrdinaryDividends, _that.getExtraOrdinaryDividends())) return false;
			if (!Objects.equals(excessDividendAmount, _that.getExcessDividendAmount())) return false;
			if (!Objects.equals(currencyAndDeterminationMethodModel, _that.getCurrencyAndDeterminationMethodModel())) return false;
			if (!Objects.equals(dividendFxTriggerDate, _that.getDividendFxTriggerDate())) return false;
			if (!Objects.equals(interestAccrualsMethod, _that.getInterestAccrualsMethod())) return false;
			if (!Objects.equals(numberOfIndexUnits, _that.getNumberOfIndexUnits())) return false;
			if (!Objects.equals(declaredCashAndCashEquivalentDividendPercentageModel, _that.getDeclaredCashAndCashEquivalentDividendPercentageModel())) return false;
			if (!Objects.equals(nonCashDividendTreatment, _that.getNonCashDividendTreatment())) return false;
			if (!Objects.equals(dividendComposition, _that.getDividendComposition())) return false;
			if (!Objects.equals(specialDividends, _that.getSpecialDividends())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendReinvestment != null ? dividendReinvestment.hashCode() : 0);
			_result = 31 * _result + (dividendEntitlement != null ? dividendEntitlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendAmount != null ? dividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendPaymentDate != null ? dividendPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dividendConditionsSequence != null ? dividendConditionsSequence.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraOrdinaryDividends != null ? extraOrdinaryDividends.hashCode() : 0);
			_result = 31 * _result + (excessDividendAmount != null ? excessDividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currencyAndDeterminationMethodModel != null ? currencyAndDeterminationMethodModel.hashCode() : 0);
			_result = 31 * _result + (dividendFxTriggerDate != null ? dividendFxTriggerDate.hashCode() : 0);
			_result = 31 * _result + (interestAccrualsMethod != null ? interestAccrualsMethod.hashCode() : 0);
			_result = 31 * _result + (numberOfIndexUnits != null ? numberOfIndexUnits.hashCode() : 0);
			_result = 31 * _result + (declaredCashAndCashEquivalentDividendPercentageModel != null ? declaredCashAndCashEquivalentDividendPercentageModel.hashCode() : 0);
			_result = 31 * _result + (nonCashDividendTreatment != null ? nonCashDividendTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendComposition != null ? dividendComposition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specialDividends != null ? specialDividends.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendConditionsBuilder {" +
				"dividendReinvestment=" + this.dividendReinvestment + ", " +
				"dividendEntitlement=" + this.dividendEntitlement + ", " +
				"dividendAmount=" + this.dividendAmount + ", " +
				"dividendPaymentDate=" + this.dividendPaymentDate + ", " +
				"dividendConditionsSequence=" + this.dividendConditionsSequence + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"extraOrdinaryDividends=" + this.extraOrdinaryDividends + ", " +
				"excessDividendAmount=" + this.excessDividendAmount + ", " +
				"currencyAndDeterminationMethodModel=" + this.currencyAndDeterminationMethodModel + ", " +
				"dividendFxTriggerDate=" + this.dividendFxTriggerDate + ", " +
				"interestAccrualsMethod=" + this.interestAccrualsMethod + ", " +
				"numberOfIndexUnits=" + this.numberOfIndexUnits + ", " +
				"declaredCashAndCashEquivalentDividendPercentageModel=" + this.declaredCashAndCashEquivalentDividendPercentageModel + ", " +
				"nonCashDividendTreatment=" + this.nonCashDividendTreatment + ", " +
				"dividendComposition=" + this.dividendComposition + ", " +
				"specialDividends=" + this.specialDividends +
			'}';
		}
	}
}
