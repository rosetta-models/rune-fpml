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
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.LoanTradePayment;
import fpml.confirmation.LoanTradePayment.LoanTradePaymentBuilder;
import fpml.confirmation.LoanTradePayment.LoanTradePaymentBuilderImpl;
import fpml.confirmation.LoanTradePayment.LoanTradePaymentImpl;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.Money;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Payment;
import fpml.confirmation.Payment.PaymentBuilder;
import fpml.confirmation.Payment.PaymentBuilderImpl;
import fpml.confirmation.Payment.PaymentImpl;
import fpml.confirmation.PaymentType;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.meta.LoanTradePaymentMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents a payment related to a loan trade.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradePayment", builder=LoanTradePayment.LoanTradePaymentBuilderImpl.class, version="${project.version}")
public interface LoanTradePayment extends Payment {

	LoanTradePaymentMeta metaData = new LoanTradePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the original loan trade.
	 */
	List<? extends LoanTradeReference> getLoanTradeReference();

	/*********************** Build Methods  ***********************/
	LoanTradePayment build();
	
	LoanTradePayment.LoanTradePaymentBuilder toBuilder();
	
	static LoanTradePayment.LoanTradePaymentBuilder builder() {
		return new LoanTradePayment.LoanTradePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradePayment> getType() {
		return LoanTradePayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrAdjustedDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentType"), processor, PaymentType.class, getPaymentType());
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradePaymentBuilder extends LoanTradePayment, Payment.PaymentBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference(int _index);
		List<? extends LoanTradeReference.LoanTradeReferenceBuilder> getLoanTradeReference();
		LoanTradePayment.LoanTradePaymentBuilder setId(String id);
		LoanTradePayment.LoanTradePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		LoanTradePayment.LoanTradePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		LoanTradePayment.LoanTradePaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate);
		LoanTradePayment.LoanTradePaymentBuilder setPaymentType(PaymentType paymentType);
		LoanTradePayment.LoanTradePaymentBuilder setSettlementInformation(SettlementInformation settlementInformation);
		LoanTradePayment.LoanTradePaymentBuilder setDiscountFactor(BigDecimal discountFactor);
		LoanTradePayment.LoanTradePaymentBuilder setPresentValueAmount(Money presentValueAmount);
		LoanTradePayment.LoanTradePaymentBuilder setHref(String href);
		LoanTradePayment.LoanTradePaymentBuilder addLoanTradeReference(LoanTradeReference loanTradeReference0);
		LoanTradePayment.LoanTradePaymentBuilder addLoanTradeReference(LoanTradeReference loanTradeReference1, int _idx);
		LoanTradePayment.LoanTradePaymentBuilder addLoanTradeReference(List<? extends LoanTradeReference> loanTradeReference2);
		LoanTradePayment.LoanTradePaymentBuilder setLoanTradeReference(List<? extends LoanTradeReference> loanTradeReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentType"), processor, PaymentType.PaymentTypeBuilder.class, getPaymentType());
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
		}
		

		LoanTradePayment.LoanTradePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradePayment  ***********************/
	class LoanTradePaymentImpl extends Payment.PaymentImpl implements LoanTradePayment {
		private final List<? extends LoanTradeReference> loanTradeReference;
		
		protected LoanTradePaymentImpl(LoanTradePayment.LoanTradePaymentBuilder builder) {
			super(builder);
			this.loanTradeReference = ofNullable(builder.getLoanTradeReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		public List<? extends LoanTradeReference> getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradePayment build() {
			return this;
		}
		
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder toBuilder() {
			LoanTradePayment.LoanTradePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradePayment.LoanTradePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradeReference()).ifPresent(builder::setLoanTradeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradePayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradePayment {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradePayment  ***********************/
	class LoanTradePaymentBuilderImpl extends Payment.PaymentBuilderImpl  implements LoanTradePayment.LoanTradePaymentBuilder {
	
		protected List<LoanTradeReference.LoanTradeReferenceBuilder> loanTradeReference = new ArrayList<>();
	
		public LoanTradePaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanTradeReference")
		public List<? extends LoanTradeReference.LoanTradeReferenceBuilder> getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference(int _index) {
		
			if (loanTradeReference==null) {
				this.loanTradeReference = new ArrayList<>();
			}
			LoanTradeReference.LoanTradeReferenceBuilder result;
			return getIndex(loanTradeReference, _index, () -> {
						LoanTradeReference.LoanTradeReferenceBuilder newLoanTradeReference = LoanTradeReference.builder();
						return newLoanTradeReference;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public LoanTradePayment.LoanTradePaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public LoanTradePayment.LoanTradePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public LoanTradePayment.LoanTradePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public LoanTradePayment.LoanTradePaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentType")
		public LoanTradePayment.LoanTradePaymentBuilder setPaymentType(PaymentType paymentType) {
			this.paymentType = paymentType==null?null:paymentType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementInformation")
		public LoanTradePayment.LoanTradePaymentBuilder setSettlementInformation(SettlementInformation settlementInformation) {
			this.settlementInformation = settlementInformation==null?null:settlementInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("discountFactor")
		public LoanTradePayment.LoanTradePaymentBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		@RosettaAttribute("presentValueAmount")
		public LoanTradePayment.LoanTradePaymentBuilder setPresentValueAmount(Money presentValueAmount) {
			this.presentValueAmount = presentValueAmount==null?null:presentValueAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("href")
		public LoanTradePayment.LoanTradePaymentBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradePayment.LoanTradePaymentBuilder addLoanTradeReference(LoanTradeReference loanTradeReference) {
			if (loanTradeReference!=null) this.loanTradeReference.add(loanTradeReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder addLoanTradeReference(LoanTradeReference loanTradeReference, int _idx) {
			getIndex(this.loanTradeReference, _idx, () -> loanTradeReference.toBuilder());
			return this;
		}
		@Override 
		public LoanTradePayment.LoanTradePaymentBuilder addLoanTradeReference(List<? extends LoanTradeReference> loanTradeReferences) {
			if (loanTradeReferences != null) {
				for (LoanTradeReference toAdd : loanTradeReferences) {
					this.loanTradeReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradePayment.LoanTradePaymentBuilder setLoanTradeReference(List<? extends LoanTradeReference> loanTradeReferences) {
			if (loanTradeReferences == null)  {
				this.loanTradeReference = new ArrayList<>();
			}
			else {
				this.loanTradeReference = loanTradeReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanTradePayment build() {
			return new LoanTradePayment.LoanTradePaymentImpl(this);
		}
		
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder prune() {
			super.prune();
			loanTradeReference = loanTradeReference.stream().filter(b->b!=null).<LoanTradeReference.LoanTradeReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradeReference()!=null && getLoanTradeReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradePayment.LoanTradePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradePayment.LoanTradePaymentBuilder o = (LoanTradePayment.LoanTradePaymentBuilder) other;
			
			merger.mergeRosetta(getLoanTradeReference(), o.getLoanTradeReference(), this::getOrCreateLoanTradeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradePayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradePaymentBuilder {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}
}
