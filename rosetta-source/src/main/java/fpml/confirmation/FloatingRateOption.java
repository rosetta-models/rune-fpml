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
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.Currency;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.FloatingRateOption;
import fpml.confirmation.FloatingRateOption.FloatingRateOptionBuilder;
import fpml.confirmation.FloatingRateOption.FloatingRateOptionBuilderImpl;
import fpml.confirmation.FloatingRateOption.FloatingRateOptionImpl;
import fpml.confirmation.FloatingRateOptionBase;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseBuilder;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseBuilderImpl;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.RateLimits;
import fpml.confirmation.meta.FloatingRateOptionMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents the accruing floating rate option associated within a facility.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FloatingRateOption", builder=FloatingRateOption.FloatingRateOptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FloatingRateOption extends FloatingRateOptionBase {

	FloatingRateOptionMeta metaData = new FloatingRateOptionMeta();

	/*********************** Getter Methods  ***********************/
	Currency getCurrency();
	PeriodModel getPeriodModel();
	RateLimits getBaseRateLimits();
	RateLimits getAllInRateLimits();
	/**
	 * A party reference to the borrower(s) permitted to exercise the cash accrual option.
	 */
	List<? extends PartyReference> getBorrowerPartyReference();
	/**
	 * The number of business days that a lender must be notified prior to a drawdown event occurring.
	 */
	Integer getDrawdownNoticeDays();
	/**
	 * The number of business days that a lender must be notified prior to an FX rate set event occurring.
	 */
	Integer getFxRateSetNoticeDays();
	/**
	 * The number of business days that a lender must be notified prior to a rate set event occurring.
	 */
	Integer getRateSetNoticeDays();

	/*********************** Build Methods  ***********************/
	FloatingRateOption build();
	
	FloatingRateOption.FloatingRateOptionBuilder toBuilder();
	
	static FloatingRateOption.FloatingRateOptionBuilder builder() {
		return new FloatingRateOption.FloatingRateOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateOption> getType() {
		return FloatingRateOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("floatingRateIndexLoanModel"), processor, FloatingRateIndexLoanModel.class, getFloatingRateIndexLoanModel());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processRosetta(path.newSubPath("baseRateLimits"), processor, RateLimits.class, getBaseRateLimits());
		processRosetta(path.newSubPath("allInRateLimits"), processor, RateLimits.class, getAllInRateLimits());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processor.processBasic(path.newSubPath("drawdownNoticeDays"), Integer.class, getDrawdownNoticeDays(), this);
		processor.processBasic(path.newSubPath("fxRateSetNoticeDays"), Integer.class, getFxRateSetNoticeDays(), this);
		processor.processBasic(path.newSubPath("rateSetNoticeDays"), Integer.class, getRateSetNoticeDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateOptionBuilder extends FloatingRateOption, FloatingRateOptionBase.FloatingRateOptionBaseBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		RateLimits.RateLimitsBuilder getOrCreateBaseRateLimits();
		RateLimits.RateLimitsBuilder getBaseRateLimits();
		RateLimits.RateLimitsBuilder getOrCreateAllInRateLimits();
		RateLimits.RateLimitsBuilder getAllInRateLimits();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getBorrowerPartyReference();
		FloatingRateOption.FloatingRateOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		FloatingRateOption.FloatingRateOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		FloatingRateOption.FloatingRateOptionBuilder setPaymentFrequency(Period paymentFrequency);
		FloatingRateOption.FloatingRateOptionBuilder setFloatingRateIndexLoanModel(FloatingRateIndexLoanModel floatingRateIndexLoanModel);
		FloatingRateOption.FloatingRateOptionBuilder setSpread(BigDecimal spread);
		FloatingRateOption.FloatingRateOptionBuilder setPikSpread(BigDecimal pikSpread);
		FloatingRateOption.FloatingRateOptionBuilder setCurrency(Currency currency);
		FloatingRateOption.FloatingRateOptionBuilder setPeriodModel(PeriodModel periodModel);
		FloatingRateOption.FloatingRateOptionBuilder setBaseRateLimits(RateLimits baseRateLimits);
		FloatingRateOption.FloatingRateOptionBuilder setAllInRateLimits(RateLimits allInRateLimits);
		FloatingRateOption.FloatingRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference0);
		FloatingRateOption.FloatingRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference1, int _idx);
		FloatingRateOption.FloatingRateOptionBuilder addBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReference2);
		FloatingRateOption.FloatingRateOptionBuilder setBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReference3);
		FloatingRateOption.FloatingRateOptionBuilder setDrawdownNoticeDays(Integer drawdownNoticeDays);
		FloatingRateOption.FloatingRateOptionBuilder setFxRateSetNoticeDays(Integer fxRateSetNoticeDays);
		FloatingRateOption.FloatingRateOptionBuilder setRateSetNoticeDays(Integer rateSetNoticeDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("floatingRateIndexLoanModel"), processor, FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder.class, getFloatingRateIndexLoanModel());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processRosetta(path.newSubPath("baseRateLimits"), processor, RateLimits.RateLimitsBuilder.class, getBaseRateLimits());
			processRosetta(path.newSubPath("allInRateLimits"), processor, RateLimits.RateLimitsBuilder.class, getAllInRateLimits());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processor.processBasic(path.newSubPath("drawdownNoticeDays"), Integer.class, getDrawdownNoticeDays(), this);
			processor.processBasic(path.newSubPath("fxRateSetNoticeDays"), Integer.class, getFxRateSetNoticeDays(), this);
			processor.processBasic(path.newSubPath("rateSetNoticeDays"), Integer.class, getRateSetNoticeDays(), this);
		}
		

		FloatingRateOption.FloatingRateOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateOption  ***********************/
	class FloatingRateOptionImpl extends FloatingRateOptionBase.FloatingRateOptionBaseImpl implements FloatingRateOption {
		private final Currency currency;
		private final PeriodModel periodModel;
		private final RateLimits baseRateLimits;
		private final RateLimits allInRateLimits;
		private final List<? extends PartyReference> borrowerPartyReference;
		private final Integer drawdownNoticeDays;
		private final Integer fxRateSetNoticeDays;
		private final Integer rateSetNoticeDays;
		
		protected FloatingRateOptionImpl(FloatingRateOption.FloatingRateOptionBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.baseRateLimits = ofNullable(builder.getBaseRateLimits()).map(f->f.build()).orElse(null);
			this.allInRateLimits = ofNullable(builder.getAllInRateLimits()).map(f->f.build()).orElse(null);
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.drawdownNoticeDays = builder.getDrawdownNoticeDays();
			this.fxRateSetNoticeDays = builder.getFxRateSetNoticeDays();
			this.rateSetNoticeDays = builder.getRateSetNoticeDays();
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		@RosettaAttribute("baseRateLimits")
		public RateLimits getBaseRateLimits() {
			return baseRateLimits;
		}
		
		@Override
		@RosettaAttribute("allInRateLimits")
		public RateLimits getAllInRateLimits() {
			return allInRateLimits;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public List<? extends PartyReference> getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("drawdownNoticeDays")
		public Integer getDrawdownNoticeDays() {
			return drawdownNoticeDays;
		}
		
		@Override
		@RosettaAttribute("fxRateSetNoticeDays")
		public Integer getFxRateSetNoticeDays() {
			return fxRateSetNoticeDays;
		}
		
		@Override
		@RosettaAttribute("rateSetNoticeDays")
		public Integer getRateSetNoticeDays() {
			return rateSetNoticeDays;
		}
		
		@Override
		public FloatingRateOption build() {
			return this;
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder toBuilder() {
			FloatingRateOption.FloatingRateOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateOption.FloatingRateOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getBaseRateLimits()).ifPresent(builder::setBaseRateLimits);
			ofNullable(getAllInRateLimits()).ifPresent(builder::setAllInRateLimits);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getDrawdownNoticeDays()).ifPresent(builder::setDrawdownNoticeDays);
			ofNullable(getFxRateSetNoticeDays()).ifPresent(builder::setFxRateSetNoticeDays);
			ofNullable(getRateSetNoticeDays()).ifPresent(builder::setRateSetNoticeDays);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(baseRateLimits, _that.getBaseRateLimits())) return false;
			if (!Objects.equals(allInRateLimits, _that.getAllInRateLimits())) return false;
			if (!ListEquals.listEquals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(drawdownNoticeDays, _that.getDrawdownNoticeDays())) return false;
			if (!Objects.equals(fxRateSetNoticeDays, _that.getFxRateSetNoticeDays())) return false;
			if (!Objects.equals(rateSetNoticeDays, _that.getRateSetNoticeDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (baseRateLimits != null ? baseRateLimits.hashCode() : 0);
			_result = 31 * _result + (allInRateLimits != null ? allInRateLimits.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (drawdownNoticeDays != null ? drawdownNoticeDays.hashCode() : 0);
			_result = 31 * _result + (fxRateSetNoticeDays != null ? fxRateSetNoticeDays.hashCode() : 0);
			_result = 31 * _result + (rateSetNoticeDays != null ? rateSetNoticeDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateOption {" +
				"currency=" + this.currency + ", " +
				"periodModel=" + this.periodModel + ", " +
				"baseRateLimits=" + this.baseRateLimits + ", " +
				"allInRateLimits=" + this.allInRateLimits + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"drawdownNoticeDays=" + this.drawdownNoticeDays + ", " +
				"fxRateSetNoticeDays=" + this.fxRateSetNoticeDays + ", " +
				"rateSetNoticeDays=" + this.rateSetNoticeDays +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateOption  ***********************/
	class FloatingRateOptionBuilderImpl extends FloatingRateOptionBase.FloatingRateOptionBaseBuilderImpl  implements FloatingRateOption.FloatingRateOptionBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected RateLimits.RateLimitsBuilder baseRateLimits;
		protected RateLimits.RateLimitsBuilder allInRateLimits;
		protected List<PartyReference.PartyReferenceBuilder> borrowerPartyReference = new ArrayList<>();
		protected Integer drawdownNoticeDays;
		protected Integer fxRateSetNoticeDays;
		protected Integer rateSetNoticeDays;
	
		public FloatingRateOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel.PeriodModelBuilder getPeriodModel() {
			return periodModel;
		}
		
		@Override
		public PeriodModel.PeriodModelBuilder getOrCreatePeriodModel() {
			PeriodModel.PeriodModelBuilder result;
			if (periodModel!=null) {
				result = periodModel;
			}
			else {
				result = periodModel = PeriodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("baseRateLimits")
		public RateLimits.RateLimitsBuilder getBaseRateLimits() {
			return baseRateLimits;
		}
		
		@Override
		public RateLimits.RateLimitsBuilder getOrCreateBaseRateLimits() {
			RateLimits.RateLimitsBuilder result;
			if (baseRateLimits!=null) {
				result = baseRateLimits;
			}
			else {
				result = baseRateLimits = RateLimits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allInRateLimits")
		public RateLimits.RateLimitsBuilder getAllInRateLimits() {
			return allInRateLimits;
		}
		
		@Override
		public RateLimits.RateLimitsBuilder getOrCreateAllInRateLimits() {
			RateLimits.RateLimitsBuilder result;
			if (allInRateLimits!=null) {
				result = allInRateLimits;
			}
			else {
				result = allInRateLimits = RateLimits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference(int _index) {
		
			if (borrowerPartyReference==null) {
				this.borrowerPartyReference = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(borrowerPartyReference, _index, () -> {
						PartyReference.PartyReferenceBuilder newBorrowerPartyReference = PartyReference.builder();
						return newBorrowerPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("drawdownNoticeDays")
		public Integer getDrawdownNoticeDays() {
			return drawdownNoticeDays;
		}
		
		@Override
		@RosettaAttribute("fxRateSetNoticeDays")
		public Integer getFxRateSetNoticeDays() {
			return fxRateSetNoticeDays;
		}
		
		@Override
		@RosettaAttribute("rateSetNoticeDays")
		public Integer getRateSetNoticeDays() {
			return rateSetNoticeDays;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public FloatingRateOption.FloatingRateOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public FloatingRateOption.FloatingRateOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public FloatingRateOption.FloatingRateOptionBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndexLoanModel")
		public FloatingRateOption.FloatingRateOptionBuilder setFloatingRateIndexLoanModel(FloatingRateIndexLoanModel floatingRateIndexLoanModel) {
			this.floatingRateIndexLoanModel = floatingRateIndexLoanModel==null?null:floatingRateIndexLoanModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spread")
		public FloatingRateOption.FloatingRateOptionBuilder setSpread(BigDecimal spread) {
			this.spread = spread==null?null:spread;
			return this;
		}
		@Override
		@RosettaAttribute("pikSpread")
		public FloatingRateOption.FloatingRateOptionBuilder setPikSpread(BigDecimal pikSpread) {
			this.pikSpread = pikSpread==null?null:pikSpread;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public FloatingRateOption.FloatingRateOptionBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public FloatingRateOption.FloatingRateOptionBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("baseRateLimits")
		public FloatingRateOption.FloatingRateOptionBuilder setBaseRateLimits(RateLimits baseRateLimits) {
			this.baseRateLimits = baseRateLimits==null?null:baseRateLimits.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allInRateLimits")
		public FloatingRateOption.FloatingRateOptionBuilder setAllInRateLimits(RateLimits allInRateLimits) {
			this.allInRateLimits = allInRateLimits==null?null:allInRateLimits.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public FloatingRateOption.FloatingRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference) {
			if (borrowerPartyReference!=null) this.borrowerPartyReference.add(borrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder addBorrowerPartyReference(PartyReference borrowerPartyReference, int _idx) {
			getIndex(this.borrowerPartyReference, _idx, () -> borrowerPartyReference.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateOption.FloatingRateOptionBuilder addBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReferences) {
			if (borrowerPartyReferences != null) {
				for (PartyReference toAdd : borrowerPartyReferences) {
					this.borrowerPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRateOption.FloatingRateOptionBuilder setBorrowerPartyReference(List<? extends PartyReference> borrowerPartyReferences) {
			if (borrowerPartyReferences == null)  {
				this.borrowerPartyReference = new ArrayList<>();
			}
			else {
				this.borrowerPartyReference = borrowerPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("drawdownNoticeDays")
		public FloatingRateOption.FloatingRateOptionBuilder setDrawdownNoticeDays(Integer drawdownNoticeDays) {
			this.drawdownNoticeDays = drawdownNoticeDays==null?null:drawdownNoticeDays;
			return this;
		}
		@Override
		@RosettaAttribute("fxRateSetNoticeDays")
		public FloatingRateOption.FloatingRateOptionBuilder setFxRateSetNoticeDays(Integer fxRateSetNoticeDays) {
			this.fxRateSetNoticeDays = fxRateSetNoticeDays==null?null:fxRateSetNoticeDays;
			return this;
		}
		@Override
		@RosettaAttribute("rateSetNoticeDays")
		public FloatingRateOption.FloatingRateOptionBuilder setRateSetNoticeDays(Integer rateSetNoticeDays) {
			this.rateSetNoticeDays = rateSetNoticeDays==null?null:rateSetNoticeDays;
			return this;
		}
		
		@Override
		public FloatingRateOption build() {
			return new FloatingRateOption.FloatingRateOptionImpl(this);
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (baseRateLimits!=null && !baseRateLimits.prune().hasData()) baseRateLimits = null;
			if (allInRateLimits!=null && !allInRateLimits.prune().hasData()) allInRateLimits = null;
			borrowerPartyReference = borrowerPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getBaseRateLimits()!=null && getBaseRateLimits().hasData()) return true;
			if (getAllInRateLimits()!=null && getAllInRateLimits().hasData()) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDrawdownNoticeDays()!=null) return true;
			if (getFxRateSetNoticeDays()!=null) return true;
			if (getRateSetNoticeDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateOption.FloatingRateOptionBuilder o = (FloatingRateOption.FloatingRateOptionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(getBaseRateLimits(), o.getBaseRateLimits(), this::setBaseRateLimits);
			merger.mergeRosetta(getAllInRateLimits(), o.getAllInRateLimits(), this::setAllInRateLimits);
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::getOrCreateBorrowerPartyReference);
			
			merger.mergeBasic(getDrawdownNoticeDays(), o.getDrawdownNoticeDays(), this::setDrawdownNoticeDays);
			merger.mergeBasic(getFxRateSetNoticeDays(), o.getFxRateSetNoticeDays(), this::setFxRateSetNoticeDays);
			merger.mergeBasic(getRateSetNoticeDays(), o.getRateSetNoticeDays(), this::setRateSetNoticeDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(baseRateLimits, _that.getBaseRateLimits())) return false;
			if (!Objects.equals(allInRateLimits, _that.getAllInRateLimits())) return false;
			if (!ListEquals.listEquals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(drawdownNoticeDays, _that.getDrawdownNoticeDays())) return false;
			if (!Objects.equals(fxRateSetNoticeDays, _that.getFxRateSetNoticeDays())) return false;
			if (!Objects.equals(rateSetNoticeDays, _that.getRateSetNoticeDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (baseRateLimits != null ? baseRateLimits.hashCode() : 0);
			_result = 31 * _result + (allInRateLimits != null ? allInRateLimits.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (drawdownNoticeDays != null ? drawdownNoticeDays.hashCode() : 0);
			_result = 31 * _result + (fxRateSetNoticeDays != null ? fxRateSetNoticeDays.hashCode() : 0);
			_result = 31 * _result + (rateSetNoticeDays != null ? rateSetNoticeDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateOptionBuilder {" +
				"currency=" + this.currency + ", " +
				"periodModel=" + this.periodModel + ", " +
				"baseRateLimits=" + this.baseRateLimits + ", " +
				"allInRateLimits=" + this.allInRateLimits + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"drawdownNoticeDays=" + this.drawdownNoticeDays + ", " +
				"fxRateSetNoticeDays=" + this.fxRateSetNoticeDays + ", " +
				"rateSetNoticeDays=" + this.rateSetNoticeDays +
			'}' + " " + super.toString();
		}
	}
}
