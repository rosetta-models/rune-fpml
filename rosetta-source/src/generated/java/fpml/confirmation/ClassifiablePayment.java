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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.ClassifiablePayment;
import fpml.confirmation.ClassifiablePayment.ClassifiablePaymentBuilder;
import fpml.confirmation.ClassifiablePayment.ClassifiablePaymentBuilderImpl;
import fpml.confirmation.ClassifiablePayment.ClassifiablePaymentImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentBuilder;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentBuilderImpl;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentType;
import fpml.confirmation.meta.ClassifiablePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A classified non negative payment.
 * @version ${project.version}
 */
@RosettaDataType(value="ClassifiablePayment", builder=ClassifiablePayment.ClassifiablePaymentBuilderImpl.class, version="${project.version}")
public interface ClassifiablePayment extends NonNegativePayment {

	ClassifiablePaymentMeta metaData = new ClassifiablePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Payment classification.
	 */
	List<? extends PaymentType> getPaymentType();

	/*********************** Build Methods  ***********************/
	ClassifiablePayment build();
	
	ClassifiablePayment.ClassifiablePaymentBuilder toBuilder();
	
	static ClassifiablePayment.ClassifiablePaymentBuilder builder() {
		return new ClassifiablePayment.ClassifiablePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClassifiablePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClassifiablePayment> getType() {
		return ClassifiablePayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentType"), processor, PaymentType.class, getPaymentType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClassifiablePaymentBuilder extends ClassifiablePayment, NonNegativePayment.NonNegativePaymentBuilder {
		PaymentType.PaymentTypeBuilder getOrCreatePaymentType(int _index);
		List<? extends PaymentType.PaymentTypeBuilder> getPaymentType();
		ClassifiablePayment.ClassifiablePaymentBuilder setId(String id);
		ClassifiablePayment.ClassifiablePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		ClassifiablePayment.ClassifiablePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		ClassifiablePayment.ClassifiablePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(PaymentType paymentType0);
		ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(PaymentType paymentType1, int _idx);
		ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(List<? extends PaymentType> paymentType2);
		ClassifiablePayment.ClassifiablePaymentBuilder setPaymentType(List<? extends PaymentType> paymentType3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentType"), processor, PaymentType.PaymentTypeBuilder.class, getPaymentType());
		}
		

		ClassifiablePayment.ClassifiablePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of ClassifiablePayment  ***********************/
	class ClassifiablePaymentImpl extends NonNegativePayment.NonNegativePaymentImpl implements ClassifiablePayment {
		private final List<? extends PaymentType> paymentType;
		
		protected ClassifiablePaymentImpl(ClassifiablePayment.ClassifiablePaymentBuilder builder) {
			super(builder);
			this.paymentType = ofNullable(builder.getPaymentType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentType")
		public List<? extends PaymentType> getPaymentType() {
			return paymentType;
		}
		
		@Override
		public ClassifiablePayment build() {
			return this;
		}
		
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder toBuilder() {
			ClassifiablePayment.ClassifiablePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClassifiablePayment.ClassifiablePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentType()).ifPresent(builder::setPaymentType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClassifiablePayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClassifiablePayment {" +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClassifiablePayment  ***********************/
	class ClassifiablePaymentBuilderImpl extends NonNegativePayment.NonNegativePaymentBuilderImpl  implements ClassifiablePayment.ClassifiablePaymentBuilder {
	
		protected List<PaymentType.PaymentTypeBuilder> paymentType = new ArrayList<>();
	
		public ClassifiablePaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentType")
		public List<? extends PaymentType.PaymentTypeBuilder> getPaymentType() {
			return paymentType;
		}
		
		public PaymentType.PaymentTypeBuilder getOrCreatePaymentType(int _index) {
		
			if (paymentType==null) {
				this.paymentType = new ArrayList<>();
			}
			PaymentType.PaymentTypeBuilder result;
			return getIndex(paymentType, _index, () -> {
						PaymentType.PaymentTypeBuilder newPaymentType = PaymentType.builder();
						return newPaymentType;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public ClassifiablePayment.ClassifiablePaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public ClassifiablePayment.ClassifiablePaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public ClassifiablePayment.ClassifiablePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public ClassifiablePayment.ClassifiablePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(PaymentType paymentType) {
			if (paymentType!=null) this.paymentType.add(paymentType.toBuilder());
			return this;
		}
		
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(PaymentType paymentType, int _idx) {
			getIndex(this.paymentType, _idx, () -> paymentType.toBuilder());
			return this;
		}
		@Override 
		public ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(List<? extends PaymentType> paymentTypes) {
			if (paymentTypes != null) {
				for (PaymentType toAdd : paymentTypes) {
					this.paymentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("paymentType")
		public ClassifiablePayment.ClassifiablePaymentBuilder setPaymentType(List<? extends PaymentType> paymentTypes) {
			if (paymentTypes == null)  {
				this.paymentType = new ArrayList<>();
			}
			else {
				this.paymentType = paymentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ClassifiablePayment build() {
			return new ClassifiablePayment.ClassifiablePaymentImpl(this);
		}
		
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder prune() {
			super.prune();
			paymentType = paymentType.stream().filter(b->b!=null).<PaymentType.PaymentTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentType()!=null && getPaymentType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ClassifiablePayment.ClassifiablePaymentBuilder o = (ClassifiablePayment.ClassifiablePaymentBuilder) other;
			
			merger.mergeRosetta(getPaymentType(), o.getPaymentType(), this::getOrCreatePaymentType);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClassifiablePayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClassifiablePaymentBuilder {" +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}
}
