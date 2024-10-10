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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.Fra;
import fpml.confirmation.Fra.FraBuilder;
import fpml.confirmation.Fra.FraBuilderImpl;
import fpml.confirmation.Fra.FraImpl;
import fpml.confirmation.FraDiscountingEnum;
import fpml.confirmation.IdentifiedRate;
import fpml.confirmation.Money;
import fpml.confirmation.Payment;
import fpml.confirmation.Period;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.RequiredIdentifierDate;
import fpml.confirmation.meta.FraMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A forward rate agreement product definition. A type defining a Forward Rate Agreement (FRA) product.
 * @version ${project.version}
 */
@RosettaDataType(value="Fra", builder=Fra.FraBuilderImpl.class, version="${project.version}")
public interface Fra extends Product {

	FraMeta metaData = new FraMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * The start date of the calculation period. This date should already be adjusted for any applicable business day convention. This is also the date when the observed rate is applied, the reset date.
	 */
	RequiredIdentifierDate getAdjustedEffectiveDate();
	/**
	 * The end date of the calculation period. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedTerminationDate();
	/**
	 * The payment date. This date is subject to adjustment in accordance with any applicable business day convention.
	 */
	AdjustableDate getPaymentDate();
	/**
	 * Specifies the fixing date relative to the reset date in terms of a business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA&#39;s Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction. The href attribute on the dateRelativeTo element should reference the id attribute on the adjustedEffectiveDate element.
	 */
	RelativeDateOffset getFixingDateOffset();
	/**
	 * The day count fraction.
	 */
	DayCountFraction getDayCountFraction();
	/**
	 * The number of days from the adjusted effective date to the adjusted termination date calculated in accordance with the applicable day count fraction.
	 */
	Integer getCalculationPeriodNumberOfDays();
	/**
	 * The notional amount.
	 */
	Money getNotional();
	/**
	 * The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 */
	IdentifiedRate getFixedRate();
	FloatingRateIndex getFloatingRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the tenor of the floating rate. A FRA can contain either one or two indexTenor instances.
	 */
	List<? extends Period> getIndexTenor();
	/**
	 * Specifies whether discounting applies and, if so, what type.
	 */
	FraDiscountingEnum getFraDiscounting();
	/**
	 * Additional payments between the principal parties (i.e. the parties referenced as the FRA buyer and seller).
	 */
	List<? extends Payment> getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	Fra build();
	
	Fra.FraBuilder toBuilder();
	
	static Fra.FraBuilder builder() {
		return new Fra.FraBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Fra> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Fra> getType() {
		return Fra.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("adjustedEffectiveDate"), processor, RequiredIdentifierDate.class, getAdjustedEffectiveDate());
		processor.processBasic(path.newSubPath("adjustedTerminationDate"), Date.class, getAdjustedTerminationDate(), this);
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
		processRosetta(path.newSubPath("fixingDateOffset"), processor, RelativeDateOffset.class, getFixingDateOffset());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
		processRosetta(path.newSubPath("notional"), processor, Money.class, getNotional());
		processRosetta(path.newSubPath("fixedRate"), processor, IdentifiedRate.class, getFixedRate());
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processor.processBasic(path.newSubPath("fraDiscounting"), FraDiscountingEnum.class, getFraDiscounting(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FraBuilder extends Fra, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		RequiredIdentifierDate.RequiredIdentifierDateBuilder getOrCreateAdjustedEffectiveDate();
		RequiredIdentifierDate.RequiredIdentifierDateBuilder getAdjustedEffectiveDate();
		AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate();
		AdjustableDate.AdjustableDateBuilder getPaymentDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFixingDateOffset();
		RelativeDateOffset.RelativeDateOffsetBuilder getFixingDateOffset();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		Money.MoneyBuilder getOrCreateNotional();
		Money.MoneyBuilder getNotional();
		IdentifiedRate.IdentifiedRateBuilder getOrCreateFixedRate();
		IdentifiedRate.IdentifiedRateBuilder getFixedRate();
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor(int _index);
		List<? extends Period.PeriodBuilder> getIndexTenor();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		Fra.FraBuilder setProductModel(ProductModel productModel);
		Fra.FraBuilder setId(String id);
		Fra.FraBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		Fra.FraBuilder setAdjustedEffectiveDate(RequiredIdentifierDate adjustedEffectiveDate);
		Fra.FraBuilder setAdjustedTerminationDate(Date adjustedTerminationDate);
		Fra.FraBuilder setPaymentDate(AdjustableDate paymentDate);
		Fra.FraBuilder setFixingDateOffset(RelativeDateOffset fixingDateOffset);
		Fra.FraBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		Fra.FraBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays);
		Fra.FraBuilder setNotional(Money notional);
		Fra.FraBuilder setFixedRate(IdentifiedRate fixedRate);
		Fra.FraBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		Fra.FraBuilder addIndexTenor(Period indexTenor0);
		Fra.FraBuilder addIndexTenor(Period indexTenor1, int _idx);
		Fra.FraBuilder addIndexTenor(List<? extends Period> indexTenor2);
		Fra.FraBuilder setIndexTenor(List<? extends Period> indexTenor3);
		Fra.FraBuilder setFraDiscounting(FraDiscountingEnum fraDiscounting);
		Fra.FraBuilder addAdditionalPayment(Payment additionalPayment0);
		Fra.FraBuilder addAdditionalPayment(Payment additionalPayment1, int _idx);
		Fra.FraBuilder addAdditionalPayment(List<? extends Payment> additionalPayment2);
		Fra.FraBuilder setAdditionalPayment(List<? extends Payment> additionalPayment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("adjustedEffectiveDate"), processor, RequiredIdentifierDate.RequiredIdentifierDateBuilder.class, getAdjustedEffectiveDate());
			processor.processBasic(path.newSubPath("adjustedTerminationDate"), Date.class, getAdjustedTerminationDate(), this);
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("fixingDateOffset"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFixingDateOffset());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
			processRosetta(path.newSubPath("notional"), processor, Money.MoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("fixedRate"), processor, IdentifiedRate.IdentifiedRateBuilder.class, getFixedRate());
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processor.processBasic(path.newSubPath("fraDiscounting"), FraDiscountingEnum.class, getFraDiscounting(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
		}
		

		Fra.FraBuilder prune();
	}

	/*********************** Immutable Implementation of Fra  ***********************/
	class FraImpl extends Product.ProductImpl implements Fra {
		private final BuyerSellerModel buyerSellerModel;
		private final RequiredIdentifierDate adjustedEffectiveDate;
		private final Date adjustedTerminationDate;
		private final AdjustableDate paymentDate;
		private final RelativeDateOffset fixingDateOffset;
		private final DayCountFraction dayCountFraction;
		private final Integer calculationPeriodNumberOfDays;
		private final Money notional;
		private final IdentifiedRate fixedRate;
		private final FloatingRateIndex floatingRateIndex;
		private final List<? extends Period> indexTenor;
		private final FraDiscountingEnum fraDiscounting;
		private final List<? extends Payment> additionalPayment;
		
		protected FraImpl(Fra.FraBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.adjustedEffectiveDate = ofNullable(builder.getAdjustedEffectiveDate()).map(f->f.build()).orElse(null);
			this.adjustedTerminationDate = builder.getAdjustedTerminationDate();
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.fixingDateOffset = ofNullable(builder.getFixingDateOffset()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.calculationPeriodNumberOfDays = builder.getCalculationPeriodNumberOfDays();
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.fixedRate = ofNullable(builder.getFixedRate()).map(f->f.build()).orElse(null);
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fraDiscounting = builder.getFraDiscounting();
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("adjustedEffectiveDate")
		public RequiredIdentifierDate getAdjustedEffectiveDate() {
			return adjustedEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("adjustedTerminationDate")
		public Date getAdjustedTerminationDate() {
			return adjustedTerminationDate;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("fixingDateOffset")
		public RelativeDateOffset getFixingDateOffset() {
			return fixingDateOffset;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("notional")
		public Money getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public IdentifiedRate getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		public List<? extends Period> getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		@RosettaAttribute("fraDiscounting")
		public FraDiscountingEnum getFraDiscounting() {
			return fraDiscounting;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public Fra build() {
			return this;
		}
		
		@Override
		public Fra.FraBuilder toBuilder() {
			Fra.FraBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Fra.FraBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getAdjustedEffectiveDate()).ifPresent(builder::setAdjustedEffectiveDate);
			ofNullable(getAdjustedTerminationDate()).ifPresent(builder::setAdjustedTerminationDate);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getFixingDateOffset()).ifPresent(builder::setFixingDateOffset);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getCalculationPeriodNumberOfDays()).ifPresent(builder::setCalculationPeriodNumberOfDays);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
			ofNullable(getFraDiscounting()).ifPresent(builder::setFraDiscounting);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Fra _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(adjustedEffectiveDate, _that.getAdjustedEffectiveDate())) return false;
			if (!Objects.equals(adjustedTerminationDate, _that.getAdjustedTerminationDate())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(fixingDateOffset, _that.getFixingDateOffset())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!ListEquals.listEquals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(fraDiscounting, _that.getFraDiscounting())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (adjustedEffectiveDate != null ? adjustedEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (adjustedTerminationDate != null ? adjustedTerminationDate.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (fixingDateOffset != null ? fixingDateOffset.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (fraDiscounting != null ? fraDiscounting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Fra {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"adjustedEffectiveDate=" + this.adjustedEffectiveDate + ", " +
				"adjustedTerminationDate=" + this.adjustedTerminationDate + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"fixingDateOffset=" + this.fixingDateOffset + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"notional=" + this.notional + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"fraDiscounting=" + this.fraDiscounting + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Fra  ***********************/
	class FraBuilderImpl extends Product.ProductBuilderImpl  implements Fra.FraBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected RequiredIdentifierDate.RequiredIdentifierDateBuilder adjustedEffectiveDate;
		protected Date adjustedTerminationDate;
		protected AdjustableDate.AdjustableDateBuilder paymentDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder fixingDateOffset;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Integer calculationPeriodNumberOfDays;
		protected Money.MoneyBuilder notional;
		protected IdentifiedRate.IdentifiedRateBuilder fixedRate;
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected List<Period.PeriodBuilder> indexTenor = new ArrayList<>();
		protected FraDiscountingEnum fraDiscounting;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
	
		public FraBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedEffectiveDate")
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder getAdjustedEffectiveDate() {
			return adjustedEffectiveDate;
		}
		
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder getOrCreateAdjustedEffectiveDate() {
			RequiredIdentifierDate.RequiredIdentifierDateBuilder result;
			if (adjustedEffectiveDate!=null) {
				result = adjustedEffectiveDate;
			}
			else {
				result = adjustedEffectiveDate = RequiredIdentifierDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedTerminationDate")
		public Date getAdjustedTerminationDate() {
			return adjustedTerminationDate;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public AdjustableDate.AdjustableDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreatePaymentDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDateOffset")
		public RelativeDateOffset.RelativeDateOffsetBuilder getFixingDateOffset() {
			return fixingDateOffset;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFixingDateOffset() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (fixingDateOffset!=null) {
				result = fixingDateOffset;
			}
			else {
				result = fixingDateOffset = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("notional")
		public Money.MoneyBuilder getNotional() {
			return notional;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNotional() {
			Money.MoneyBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public IdentifiedRate.IdentifiedRateBuilder getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public IdentifiedRate.IdentifiedRateBuilder getOrCreateFixedRate() {
			IdentifiedRate.IdentifiedRateBuilder result;
			if (fixedRate!=null) {
				result = fixedRate;
			}
			else {
				result = fixedRate = IdentifiedRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		public List<? extends Period.PeriodBuilder> getIndexTenor() {
			return indexTenor;
		}
		
		public Period.PeriodBuilder getOrCreateIndexTenor(int _index) {
		
			if (indexTenor==null) {
				this.indexTenor = new ArrayList<>();
			}
			Period.PeriodBuilder result;
			return getIndex(indexTenor, _index, () -> {
						Period.PeriodBuilder newIndexTenor = Period.builder();
						return newIndexTenor;
					});
		}
		
		@Override
		@RosettaAttribute("fraDiscounting")
		public FraDiscountingEnum getFraDiscounting() {
			return fraDiscounting;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		public Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index) {
		
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			Payment.PaymentBuilder result;
			return getIndex(additionalPayment, _index, () -> {
						Payment.PaymentBuilder newAdditionalPayment = Payment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public Fra.FraBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Fra.FraBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public Fra.FraBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedEffectiveDate")
		public Fra.FraBuilder setAdjustedEffectiveDate(RequiredIdentifierDate adjustedEffectiveDate) {
			this.adjustedEffectiveDate = adjustedEffectiveDate==null?null:adjustedEffectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedTerminationDate")
		public Fra.FraBuilder setAdjustedTerminationDate(Date adjustedTerminationDate) {
			this.adjustedTerminationDate = adjustedTerminationDate==null?null:adjustedTerminationDate;
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public Fra.FraBuilder setPaymentDate(AdjustableDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDateOffset")
		public Fra.FraBuilder setFixingDateOffset(RelativeDateOffset fixingDateOffset) {
			this.fixingDateOffset = fixingDateOffset==null?null:fixingDateOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public Fra.FraBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		public Fra.FraBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays) {
			this.calculationPeriodNumberOfDays = calculationPeriodNumberOfDays==null?null:calculationPeriodNumberOfDays;
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public Fra.FraBuilder setNotional(Money notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public Fra.FraBuilder setFixedRate(IdentifiedRate fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndex")
		public Fra.FraBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		@Override
		public Fra.FraBuilder addIndexTenor(Period indexTenor) {
			if (indexTenor!=null) this.indexTenor.add(indexTenor.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addIndexTenor(Period indexTenor, int _idx) {
			getIndex(this.indexTenor, _idx, () -> indexTenor.toBuilder());
			return this;
		}
		@Override 
		public Fra.FraBuilder addIndexTenor(List<? extends Period> indexTenors) {
			if (indexTenors != null) {
				for (Period toAdd : indexTenors) {
					this.indexTenor.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("indexTenor")
		public Fra.FraBuilder setIndexTenor(List<? extends Period> indexTenors) {
			if (indexTenors == null)  {
				this.indexTenor = new ArrayList<>();
			}
			else {
				this.indexTenor = indexTenors.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fraDiscounting")
		public Fra.FraBuilder setFraDiscounting(FraDiscountingEnum fraDiscounting) {
			this.fraDiscounting = fraDiscounting==null?null:fraDiscounting;
			return this;
		}
		@Override
		public Fra.FraBuilder addAdditionalPayment(Payment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public Fra.FraBuilder addAdditionalPayment(Payment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public Fra.FraBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public Fra.FraBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments == null)  {
				this.additionalPayment = new ArrayList<>();
			}
			else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Fra build() {
			return new Fra.FraImpl(this);
		}
		
		@Override
		public Fra.FraBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Fra.FraBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (adjustedEffectiveDate!=null && !adjustedEffectiveDate.prune().hasData()) adjustedEffectiveDate = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (fixingDateOffset!=null && !fixingDateOffset.prune().hasData()) fixingDateOffset = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (fixedRate!=null && !fixedRate.prune().hasData()) fixedRate = null;
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			indexTenor = indexTenor.stream().filter(b->b!=null).<Period.PeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getAdjustedEffectiveDate()!=null && getAdjustedEffectiveDate().hasData()) return true;
			if (getAdjustedTerminationDate()!=null) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getFixingDateOffset()!=null && getFixingDateOffset().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getCalculationPeriodNumberOfDays()!=null) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getFixedRate()!=null && getFixedRate().hasData()) return true;
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFraDiscounting()!=null) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Fra.FraBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Fra.FraBuilder o = (Fra.FraBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getAdjustedEffectiveDate(), o.getAdjustedEffectiveDate(), this::setAdjustedEffectiveDate);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getFixingDateOffset(), o.getFixingDateOffset(), this::setFixingDateOffset);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::getOrCreateIndexTenor);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			
			merger.mergeBasic(getAdjustedTerminationDate(), o.getAdjustedTerminationDate(), this::setAdjustedTerminationDate);
			merger.mergeBasic(getCalculationPeriodNumberOfDays(), o.getCalculationPeriodNumberOfDays(), this::setCalculationPeriodNumberOfDays);
			merger.mergeBasic(getFraDiscounting(), o.getFraDiscounting(), this::setFraDiscounting);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Fra _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(adjustedEffectiveDate, _that.getAdjustedEffectiveDate())) return false;
			if (!Objects.equals(adjustedTerminationDate, _that.getAdjustedTerminationDate())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(fixingDateOffset, _that.getFixingDateOffset())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!ListEquals.listEquals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(fraDiscounting, _that.getFraDiscounting())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (adjustedEffectiveDate != null ? adjustedEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (adjustedTerminationDate != null ? adjustedTerminationDate.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (fixingDateOffset != null ? fixingDateOffset.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (fraDiscounting != null ? fraDiscounting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FraBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"adjustedEffectiveDate=" + this.adjustedEffectiveDate + ", " +
				"adjustedTerminationDate=" + this.adjustedTerminationDate + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"fixingDateOffset=" + this.fixingDateOffset + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"notional=" + this.notional + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"fraDiscounting=" + this.fraDiscounting + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}
