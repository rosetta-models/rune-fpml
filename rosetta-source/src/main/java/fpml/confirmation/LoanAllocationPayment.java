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
import fpml.confirmation.LoanAllocationPayment;
import fpml.confirmation.LoanAllocationPayment.LoanAllocationPaymentBuilder;
import fpml.confirmation.LoanAllocationPayment.LoanAllocationPaymentBuilderImpl;
import fpml.confirmation.LoanAllocationPayment.LoanAllocationPaymentImpl;
import fpml.confirmation.LoanAllocationPaymentSequence;
import fpml.confirmation.Money;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Payment;
import fpml.confirmation.Payment.PaymentBuilder;
import fpml.confirmation.Payment.PaymentBuilderImpl;
import fpml.confirmation.Payment.PaymentImpl;
import fpml.confirmation.PaymentType;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.meta.LoanAllocationPaymentMeta;
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
@RosettaDataType(value="LoanAllocationPayment", builder=LoanAllocationPayment.LoanAllocationPaymentBuilderImpl.class, version="${project.version}")
public interface LoanAllocationPayment extends Payment {

	LoanAllocationPaymentMeta metaData = new LoanAllocationPaymentMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends LoanAllocationPaymentSequence> getLoanAllocationPaymentSequence();

	/*********************** Build Methods  ***********************/
	LoanAllocationPayment build();
	
	LoanAllocationPayment.LoanAllocationPaymentBuilder toBuilder();
	
	static LoanAllocationPayment.LoanAllocationPaymentBuilder builder() {
		return new LoanAllocationPayment.LoanAllocationPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationPayment> getType() {
		return LoanAllocationPayment.class;
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
		processRosetta(path.newSubPath("loanAllocationPaymentSequence"), processor, LoanAllocationPaymentSequence.class, getLoanAllocationPaymentSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationPaymentBuilder extends LoanAllocationPayment, Payment.PaymentBuilder {
		LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder getOrCreateLoanAllocationPaymentSequence(int _index);
		List<? extends LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder> getLoanAllocationPaymentSequence();
		LoanAllocationPayment.LoanAllocationPaymentBuilder setId(String id);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentType(PaymentType paymentType);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setSettlementInformation(SettlementInformation settlementInformation);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setDiscountFactor(BigDecimal discountFactor);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setPresentValueAmount(Money presentValueAmount);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setHref(String href);
		LoanAllocationPayment.LoanAllocationPaymentBuilder addLoanAllocationPaymentSequence(LoanAllocationPaymentSequence loanAllocationPaymentSequence0);
		LoanAllocationPayment.LoanAllocationPaymentBuilder addLoanAllocationPaymentSequence(LoanAllocationPaymentSequence loanAllocationPaymentSequence1, int _idx);
		LoanAllocationPayment.LoanAllocationPaymentBuilder addLoanAllocationPaymentSequence(List<? extends LoanAllocationPaymentSequence> loanAllocationPaymentSequence2);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setLoanAllocationPaymentSequence(List<? extends LoanAllocationPaymentSequence> loanAllocationPaymentSequence3);

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
			processRosetta(path.newSubPath("loanAllocationPaymentSequence"), processor, LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder.class, getLoanAllocationPaymentSequence());
		}
		

		LoanAllocationPayment.LoanAllocationPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationPayment  ***********************/
	class LoanAllocationPaymentImpl extends Payment.PaymentImpl implements LoanAllocationPayment {
		private final List<? extends LoanAllocationPaymentSequence> loanAllocationPaymentSequence;
		
		protected LoanAllocationPaymentImpl(LoanAllocationPayment.LoanAllocationPaymentBuilder builder) {
			super(builder);
			this.loanAllocationPaymentSequence = ofNullable(builder.getLoanAllocationPaymentSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanAllocationPaymentSequence")
		public List<? extends LoanAllocationPaymentSequence> getLoanAllocationPaymentSequence() {
			return loanAllocationPaymentSequence;
		}
		
		@Override
		public LoanAllocationPayment build() {
			return this;
		}
		
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder toBuilder() {
			LoanAllocationPayment.LoanAllocationPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationPayment.LoanAllocationPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanAllocationPaymentSequence()).ifPresent(builder::setLoanAllocationPaymentSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationPayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanAllocationPaymentSequence, _that.getLoanAllocationPaymentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanAllocationPaymentSequence != null ? loanAllocationPaymentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationPayment {" +
				"loanAllocationPaymentSequence=" + this.loanAllocationPaymentSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationPayment  ***********************/
	class LoanAllocationPaymentBuilderImpl extends Payment.PaymentBuilderImpl  implements LoanAllocationPayment.LoanAllocationPaymentBuilder {
	
		protected List<LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder> loanAllocationPaymentSequence = new ArrayList<>();
	
		public LoanAllocationPaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanAllocationPaymentSequence")
		public List<? extends LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder> getLoanAllocationPaymentSequence() {
			return loanAllocationPaymentSequence;
		}
		
		@Override
		public LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder getOrCreateLoanAllocationPaymentSequence(int _index) {
		
			if (loanAllocationPaymentSequence==null) {
				this.loanAllocationPaymentSequence = new ArrayList<>();
			}
			LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder result;
			return getIndex(loanAllocationPaymentSequence, _index, () -> {
						LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder newLoanAllocationPaymentSequence = LoanAllocationPaymentSequence.builder();
						return newLoanAllocationPaymentSequence;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentType")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentType(PaymentType paymentType) {
			this.paymentType = paymentType==null?null:paymentType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementInformation")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setSettlementInformation(SettlementInformation settlementInformation) {
			this.settlementInformation = settlementInformation==null?null:settlementInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("discountFactor")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		@RosettaAttribute("presentValueAmount")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setPresentValueAmount(Money presentValueAmount) {
			this.presentValueAmount = presentValueAmount==null?null:presentValueAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("href")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		@Override
		@RosettaAttribute("loanAllocationPaymentSequence")
		public LoanAllocationPayment.LoanAllocationPaymentBuilder addLoanAllocationPaymentSequence(LoanAllocationPaymentSequence loanAllocationPaymentSequence) {
			if (loanAllocationPaymentSequence!=null) this.loanAllocationPaymentSequence.add(loanAllocationPaymentSequence.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder addLoanAllocationPaymentSequence(LoanAllocationPaymentSequence loanAllocationPaymentSequence, int _idx) {
			getIndex(this.loanAllocationPaymentSequence, _idx, () -> loanAllocationPaymentSequence.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationPayment.LoanAllocationPaymentBuilder addLoanAllocationPaymentSequence(List<? extends LoanAllocationPaymentSequence> loanAllocationPaymentSequences) {
			if (loanAllocationPaymentSequences != null) {
				for (LoanAllocationPaymentSequence toAdd : loanAllocationPaymentSequences) {
					this.loanAllocationPaymentSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setLoanAllocationPaymentSequence(List<? extends LoanAllocationPaymentSequence> loanAllocationPaymentSequences) {
			if (loanAllocationPaymentSequences == null)  {
				this.loanAllocationPaymentSequence = new ArrayList<>();
			}
			else {
				this.loanAllocationPaymentSequence = loanAllocationPaymentSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanAllocationPayment build() {
			return new LoanAllocationPayment.LoanAllocationPaymentImpl(this);
		}
		
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder prune() {
			super.prune();
			loanAllocationPaymentSequence = loanAllocationPaymentSequence.stream().filter(b->b!=null).<LoanAllocationPaymentSequence.LoanAllocationPaymentSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanAllocationPaymentSequence()!=null && getLoanAllocationPaymentSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationPayment.LoanAllocationPaymentBuilder o = (LoanAllocationPayment.LoanAllocationPaymentBuilder) other;
			
			merger.mergeRosetta(getLoanAllocationPaymentSequence(), o.getLoanAllocationPaymentSequence(), this::getOrCreateLoanAllocationPaymentSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationPayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanAllocationPaymentSequence, _that.getLoanAllocationPaymentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanAllocationPaymentSequence != null ? loanAllocationPaymentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationPaymentBuilder {" +
				"loanAllocationPaymentSequence=" + this.loanAllocationPaymentSequence +
			'}' + " " + super.toString();
		}
	}
}
