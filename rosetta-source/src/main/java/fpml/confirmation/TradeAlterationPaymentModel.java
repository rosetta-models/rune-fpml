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
import fpml.confirmation.Payment;
import fpml.confirmation.TradeAlterationPaymentModel;
import fpml.confirmation.TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder;
import fpml.confirmation.TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilderImpl;
import fpml.confirmation.TradeAlterationPaymentModel.TradeAlterationPaymentModelImpl;
import fpml.confirmation.meta.TradeAlterationPaymentModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model group defining a payment structure.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeAlterationPaymentModel", builder=TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilderImpl.class, version="${project.version}")
public interface TradeAlterationPaymentModel extends RosettaModelObject {

	TradeAlterationPaymentModelMeta metaData = new TradeAlterationPaymentModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes a payment made in settlement of the change. Normally there will be a single fee, but there could be additional payments such as principal exchanges resulting from the termination.
	 */
	List<? extends Payment> getPayment();

	/*********************** Build Methods  ***********************/
	TradeAlterationPaymentModel build();
	
	TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder toBuilder();
	
	static TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder builder() {
		return new TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeAlterationPaymentModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeAlterationPaymentModel> getType() {
		return TradeAlterationPaymentModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeAlterationPaymentModelBuilder extends TradeAlterationPaymentModel, RosettaModelObjectBuilder {
		Payment.PaymentBuilder getOrCreatePayment(int _index);
		List<? extends Payment.PaymentBuilder> getPayment();
		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder addPayment(Payment payment0);
		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder addPayment(Payment payment1, int _idx);
		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder addPayment(List<? extends Payment> payment2);
		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder setPayment(List<? extends Payment> payment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeAlterationPaymentModel  ***********************/
	class TradeAlterationPaymentModelImpl implements TradeAlterationPaymentModel {
		private final List<? extends Payment> payment;
		
		protected TradeAlterationPaymentModelImpl(TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder builder) {
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payment")
		public List<? extends Payment> getPayment() {
			return payment;
		}
		
		@Override
		public TradeAlterationPaymentModel build() {
			return this;
		}
		
		@Override
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder toBuilder() {
			TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder builder) {
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeAlterationPaymentModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeAlterationPaymentModel {" +
				"payment=" + this.payment +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeAlterationPaymentModel  ***********************/
	class TradeAlterationPaymentModelBuilderImpl implements TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder {
	
		protected List<Payment.PaymentBuilder> payment = new ArrayList<>();
	
		public TradeAlterationPaymentModelBuilderImpl() {
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
		@RosettaAttribute("payment")
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder addPayment(Payment payment) {
			if (payment!=null) this.payment.add(payment.toBuilder());
			return this;
		}
		
		@Override
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder addPayment(Payment payment, int _idx) {
			getIndex(this.payment, _idx, () -> payment.toBuilder());
			return this;
		}
		@Override 
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder addPayment(List<? extends Payment> payments) {
			if (payments != null) {
				for (Payment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder setPayment(List<? extends Payment> payments) {
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
		public TradeAlterationPaymentModel build() {
			return new TradeAlterationPaymentModel.TradeAlterationPaymentModelImpl(this);
		}
		
		@Override
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder prune() {
			payment = payment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder o = (TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder) other;
			
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeAlterationPaymentModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeAlterationPaymentModelBuilder {" +
				"payment=" + this.payment +
			'}';
		}
	}
}
