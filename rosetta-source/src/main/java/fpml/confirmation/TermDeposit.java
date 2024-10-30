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
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FxTenorModel;
import fpml.confirmation.Money;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Payment;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.TermDeposit;
import fpml.confirmation.TermDeposit.TermDepositBuilder;
import fpml.confirmation.TermDeposit.TermDepositBuilderImpl;
import fpml.confirmation.TermDeposit.TermDepositImpl;
import fpml.confirmation.TermDepositFeatures;
import fpml.confirmation.meta.TermDepositMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A term deposit product definition. A class defining the content model for a term deposit product.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TermDeposit", builder=TermDeposit.TermDepositBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TermDeposit extends Product {

	TermDepositMeta metaData = new TermDepositMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * The start date of the calculation period.
	 */
	Date getStartDate();
	/**
	 * The end date of the calculation period. This date should already be adjusted for any applicable business day convention.
	 */
	Date getMaturityDate();
	FxTenorModel getFxTenorModel();
	/**
	 * The principal amount of the trade.
	 */
	PositiveMoney getPrincipal();
	/**
	 * The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 */
	BigDecimal getFixedRate();
	/**
	 * The day count fraction.
	 */
	DayCountFraction getDayCountFraction();
	/**
	 * An optional container that holds additional features of the deposit (e.g. Dual Currency feature).
	 */
	TermDepositFeatures getFeatures();
	/**
	 * The total interest of at maturity of the trade.
	 */
	Money getInterest();
	/**
	 * A known payment between two parties.
	 */
	List<? extends Payment> getPayment();

	/*********************** Build Methods  ***********************/
	TermDeposit build();
	
	TermDeposit.TermDepositBuilder toBuilder();
	
	static TermDeposit.TermDepositBuilder builder() {
		return new TermDeposit.TermDepositBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TermDeposit> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TermDeposit> getType() {
		return TermDeposit.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
		processRosetta(path.newSubPath("fxTenorModel"), processor, FxTenorModel.class, getFxTenorModel());
		processRosetta(path.newSubPath("principal"), processor, PositiveMoney.class, getPrincipal());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("features"), processor, TermDepositFeatures.class, getFeatures());
		processRosetta(path.newSubPath("interest"), processor, Money.class, getInterest());
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TermDepositBuilder extends TermDeposit, Product.ProductBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		FxTenorModel.FxTenorModelBuilder getOrCreateFxTenorModel();
		FxTenorModel.FxTenorModelBuilder getFxTenorModel();
		PositiveMoney.PositiveMoneyBuilder getOrCreatePrincipal();
		PositiveMoney.PositiveMoneyBuilder getPrincipal();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		TermDepositFeatures.TermDepositFeaturesBuilder getOrCreateFeatures();
		TermDepositFeatures.TermDepositFeaturesBuilder getFeatures();
		Money.MoneyBuilder getOrCreateInterest();
		Money.MoneyBuilder getInterest();
		Payment.PaymentBuilder getOrCreatePayment(int _index);
		List<? extends Payment.PaymentBuilder> getPayment();
		TermDeposit.TermDepositBuilder setProductModel(ProductModel productModel);
		TermDeposit.TermDepositBuilder setId(String id);
		TermDeposit.TermDepositBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		TermDeposit.TermDepositBuilder setStartDate(Date startDate);
		TermDeposit.TermDepositBuilder setMaturityDate(Date maturityDate);
		TermDeposit.TermDepositBuilder setFxTenorModel(FxTenorModel fxTenorModel);
		TermDeposit.TermDepositBuilder setPrincipal(PositiveMoney principal);
		TermDeposit.TermDepositBuilder setFixedRate(BigDecimal fixedRate);
		TermDeposit.TermDepositBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		TermDeposit.TermDepositBuilder setFeatures(TermDepositFeatures features);
		TermDeposit.TermDepositBuilder setInterest(Money interest);
		TermDeposit.TermDepositBuilder addPayment(Payment payment0);
		TermDeposit.TermDepositBuilder addPayment(Payment payment1, int _idx);
		TermDeposit.TermDepositBuilder addPayment(List<? extends Payment> payment2);
		TermDeposit.TermDepositBuilder setPayment(List<? extends Payment> payment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
			processRosetta(path.newSubPath("fxTenorModel"), processor, FxTenorModel.FxTenorModelBuilder.class, getFxTenorModel());
			processRosetta(path.newSubPath("principal"), processor, PositiveMoney.PositiveMoneyBuilder.class, getPrincipal());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("features"), processor, TermDepositFeatures.TermDepositFeaturesBuilder.class, getFeatures());
			processRosetta(path.newSubPath("interest"), processor, Money.MoneyBuilder.class, getInterest());
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TermDeposit.TermDepositBuilder prune();
	}

	/*********************** Immutable Implementation of TermDeposit  ***********************/
	class TermDepositImpl extends Product.ProductImpl implements TermDeposit {
		private final PayerReceiverModel payerReceiverModel;
		private final Date startDate;
		private final Date maturityDate;
		private final FxTenorModel fxTenorModel;
		private final PositiveMoney principal;
		private final BigDecimal fixedRate;
		private final DayCountFraction dayCountFraction;
		private final TermDepositFeatures features;
		private final Money interest;
		private final List<? extends Payment> payment;
		
		protected TermDepositImpl(TermDeposit.TermDepositBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.startDate = builder.getStartDate();
			this.maturityDate = builder.getMaturityDate();
			this.fxTenorModel = ofNullable(builder.getFxTenorModel()).map(f->f.build()).orElse(null);
			this.principal = ofNullable(builder.getPrincipal()).map(f->f.build()).orElse(null);
			this.fixedRate = builder.getFixedRate();
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.features = ofNullable(builder.getFeatures()).map(f->f.build()).orElse(null);
			this.interest = ofNullable(builder.getInterest()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("fxTenorModel")
		public FxTenorModel getFxTenorModel() {
			return fxTenorModel;
		}
		
		@Override
		@RosettaAttribute("principal")
		public PositiveMoney getPrincipal() {
			return principal;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("features")
		public TermDepositFeatures getFeatures() {
			return features;
		}
		
		@Override
		@RosettaAttribute("interest")
		public Money getInterest() {
			return interest;
		}
		
		@Override
		@RosettaAttribute("payment")
		public List<? extends Payment> getPayment() {
			return payment;
		}
		
		@Override
		public TermDeposit build() {
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder toBuilder() {
			TermDeposit.TermDepositBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermDeposit.TermDepositBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
			ofNullable(getFxTenorModel()).ifPresent(builder::setFxTenorModel);
			ofNullable(getPrincipal()).ifPresent(builder::setPrincipal);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getFeatures()).ifPresent(builder::setFeatures);
			ofNullable(getInterest()).ifPresent(builder::setInterest);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TermDeposit _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(fxTenorModel, _that.getFxTenorModel())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(features, _that.getFeatures())) return false;
			if (!Objects.equals(interest, _that.getInterest())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (fxTenorModel != null ? fxTenorModel.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (features != null ? features.hashCode() : 0);
			_result = 31 * _result + (interest != null ? interest.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermDeposit {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"startDate=" + this.startDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"fxTenorModel=" + this.fxTenorModel + ", " +
				"principal=" + this.principal + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"features=" + this.features + ", " +
				"interest=" + this.interest + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TermDeposit  ***********************/
	class TermDepositBuilderImpl extends Product.ProductBuilderImpl  implements TermDeposit.TermDepositBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected Date startDate;
		protected Date maturityDate;
		protected FxTenorModel.FxTenorModelBuilder fxTenorModel;
		protected PositiveMoney.PositiveMoneyBuilder principal;
		protected BigDecimal fixedRate;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected TermDepositFeatures.TermDepositFeaturesBuilder features;
		protected Money.MoneyBuilder interest;
		protected List<Payment.PaymentBuilder> payment = new ArrayList<>();
	
		public TermDepositBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("fxTenorModel")
		public FxTenorModel.FxTenorModelBuilder getFxTenorModel() {
			return fxTenorModel;
		}
		
		@Override
		public FxTenorModel.FxTenorModelBuilder getOrCreateFxTenorModel() {
			FxTenorModel.FxTenorModelBuilder result;
			if (fxTenorModel!=null) {
				result = fxTenorModel;
			}
			else {
				result = fxTenorModel = FxTenorModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principal")
		public PositiveMoney.PositiveMoneyBuilder getPrincipal() {
			return principal;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreatePrincipal() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (principal!=null) {
				result = principal;
			}
			else {
				result = principal = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
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
		@RosettaAttribute("features")
		public TermDepositFeatures.TermDepositFeaturesBuilder getFeatures() {
			return features;
		}
		
		@Override
		public TermDepositFeatures.TermDepositFeaturesBuilder getOrCreateFeatures() {
			TermDepositFeatures.TermDepositFeaturesBuilder result;
			if (features!=null) {
				result = features;
			}
			else {
				result = features = TermDepositFeatures.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interest")
		public Money.MoneyBuilder getInterest() {
			return interest;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateInterest() {
			Money.MoneyBuilder result;
			if (interest!=null) {
				result = interest;
			}
			else {
				result = interest = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		public List<? extends Payment.PaymentBuilder> getPayment() {
			return payment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePayment(int _index) {
		
			if (payment==null) {
				this.payment = new ArrayList<>();
			}
			Payment.PaymentBuilder result;
			return getIndex(payment, _index, () -> {
						Payment.PaymentBuilder newPayment = Payment.builder();
						return newPayment;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public TermDeposit.TermDepositBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public TermDeposit.TermDepositBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public TermDeposit.TermDepositBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("startDate")
		public TermDeposit.TermDepositBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("maturityDate")
		public TermDeposit.TermDepositBuilder setMaturityDate(Date maturityDate) {
			this.maturityDate = maturityDate==null?null:maturityDate;
			return this;
		}
		@Override
		@RosettaAttribute("fxTenorModel")
		public TermDeposit.TermDepositBuilder setFxTenorModel(FxTenorModel fxTenorModel) {
			this.fxTenorModel = fxTenorModel==null?null:fxTenorModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("principal")
		public TermDeposit.TermDepositBuilder setPrincipal(PositiveMoney principal) {
			this.principal = principal==null?null:principal.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public TermDeposit.TermDepositBuilder setFixedRate(BigDecimal fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate;
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public TermDeposit.TermDepositBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("features")
		public TermDeposit.TermDepositBuilder setFeatures(TermDepositFeatures features) {
			this.features = features==null?null:features.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interest")
		public TermDeposit.TermDepositBuilder setInterest(Money interest) {
			this.interest = interest==null?null:interest.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public TermDeposit.TermDepositBuilder addPayment(Payment payment) {
			if (payment!=null) this.payment.add(payment.toBuilder());
			return this;
		}
		
		@Override
		public TermDeposit.TermDepositBuilder addPayment(Payment payment, int _idx) {
			getIndex(this.payment, _idx, () -> payment.toBuilder());
			return this;
		}
		@Override 
		public TermDeposit.TermDepositBuilder addPayment(List<? extends Payment> payments) {
			if (payments != null) {
				for (Payment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TermDeposit.TermDepositBuilder setPayment(List<? extends Payment> payments) {
			if (payments == null)  {
				this.payment = new ArrayList<>();
			}
			else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TermDeposit build() {
			return new TermDeposit.TermDepositImpl(this);
		}
		
		@Override
		public TermDeposit.TermDepositBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermDeposit.TermDepositBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (fxTenorModel!=null && !fxTenorModel.prune().hasData()) fxTenorModel = null;
			if (principal!=null && !principal.prune().hasData()) principal = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (features!=null && !features.prune().hasData()) features = null;
			if (interest!=null && !interest.prune().hasData()) interest = null;
			payment = payment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getMaturityDate()!=null) return true;
			if (getFxTenorModel()!=null && getFxTenorModel().hasData()) return true;
			if (getPrincipal()!=null && getPrincipal().hasData()) return true;
			if (getFixedRate()!=null) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getFeatures()!=null && getFeatures().hasData()) return true;
			if (getInterest()!=null && getInterest().hasData()) return true;
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermDeposit.TermDepositBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TermDeposit.TermDepositBuilder o = (TermDeposit.TermDepositBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getFxTenorModel(), o.getFxTenorModel(), this::setFxTenorModel);
			merger.mergeRosetta(getPrincipal(), o.getPrincipal(), this::setPrincipal);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getFeatures(), o.getFeatures(), this::setFeatures);
			merger.mergeRosetta(getInterest(), o.getInterest(), this::setInterest);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TermDeposit _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(fxTenorModel, _that.getFxTenorModel())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(features, _that.getFeatures())) return false;
			if (!Objects.equals(interest, _that.getInterest())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (fxTenorModel != null ? fxTenorModel.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (features != null ? features.hashCode() : 0);
			_result = 31 * _result + (interest != null ? interest.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermDepositBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"startDate=" + this.startDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"fxTenorModel=" + this.fxTenorModel + ", " +
				"principal=" + this.principal + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"features=" + this.features + ", " +
				"interest=" + this.interest + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
