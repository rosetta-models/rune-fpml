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
import fpml.confirmation.DateRelativeToPaymentDates;
import fpml.confirmation.DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder;
import fpml.confirmation.DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilderImpl;
import fpml.confirmation.DateRelativeToPaymentDates.DateRelativeToPaymentDatesImpl;
import fpml.confirmation.PaymentDatesReference;
import fpml.confirmation.meta.DateRelativeToPaymentDatesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type to provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DateRelativeToPaymentDates", builder=DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DateRelativeToPaymentDates extends RosettaModelObject {

	DateRelativeToPaymentDatesMeta metaData = new DateRelativeToPaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A set of href pointers to payment dates defined somewhere else in the document.
	 */
	List<? extends PaymentDatesReference> getPaymentDatesReference();

	/*********************** Build Methods  ***********************/
	DateRelativeToPaymentDates build();
	
	DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder();
	
	static DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder() {
		return new DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateRelativeToPaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DateRelativeToPaymentDates> getType() {
		return DateRelativeToPaymentDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("paymentDatesReference"), processor, PaymentDatesReference.class, getPaymentDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateRelativeToPaymentDatesBuilder extends DateRelativeToPaymentDates, RosettaModelObjectBuilder {
		PaymentDatesReference.PaymentDatesReferenceBuilder getOrCreatePaymentDatesReference(int _index);
		List<? extends PaymentDatesReference.PaymentDatesReferenceBuilder> getPaymentDatesReference();
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(PaymentDatesReference paymentDatesReference0);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(PaymentDatesReference paymentDatesReference1, int _idx);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(List<? extends PaymentDatesReference> paymentDatesReference2);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder setPaymentDatesReference(List<? extends PaymentDatesReference> paymentDatesReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("paymentDatesReference"), processor, PaymentDatesReference.PaymentDatesReferenceBuilder.class, getPaymentDatesReference());
		}
		

		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of DateRelativeToPaymentDates  ***********************/
	class DateRelativeToPaymentDatesImpl implements DateRelativeToPaymentDates {
		private final List<? extends PaymentDatesReference> paymentDatesReference;
		
		protected DateRelativeToPaymentDatesImpl(DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder) {
			this.paymentDatesReference = ofNullable(builder.getPaymentDatesReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentDatesReference")
		public List<? extends PaymentDatesReference> getPaymentDatesReference() {
			return paymentDatesReference;
		}
		
		@Override
		public DateRelativeToPaymentDates build() {
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder() {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder) {
			ofNullable(getPaymentDatesReference()).ifPresent(builder::setPaymentDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToPaymentDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDatesReference, _that.getPaymentDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDatesReference != null ? paymentDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToPaymentDates {" +
				"paymentDatesReference=" + this.paymentDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of DateRelativeToPaymentDates  ***********************/
	class DateRelativeToPaymentDatesBuilderImpl implements DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder {
	
		protected List<PaymentDatesReference.PaymentDatesReferenceBuilder> paymentDatesReference = new ArrayList<>();
	
		public DateRelativeToPaymentDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentDatesReference")
		public List<? extends PaymentDatesReference.PaymentDatesReferenceBuilder> getPaymentDatesReference() {
			return paymentDatesReference;
		}
		
		@Override
		public PaymentDatesReference.PaymentDatesReferenceBuilder getOrCreatePaymentDatesReference(int _index) {
		
			if (paymentDatesReference==null) {
				this.paymentDatesReference = new ArrayList<>();
			}
			PaymentDatesReference.PaymentDatesReferenceBuilder result;
			return getIndex(paymentDatesReference, _index, () -> {
						PaymentDatesReference.PaymentDatesReferenceBuilder newPaymentDatesReference = PaymentDatesReference.builder();
						return newPaymentDatesReference;
					});
		}
		
		@Override
		@RosettaAttribute("paymentDatesReference")
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(PaymentDatesReference paymentDatesReference) {
			if (paymentDatesReference!=null) this.paymentDatesReference.add(paymentDatesReference.toBuilder());
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(PaymentDatesReference paymentDatesReference, int _idx) {
			getIndex(this.paymentDatesReference, _idx, () -> paymentDatesReference.toBuilder());
			return this;
		}
		@Override 
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(List<? extends PaymentDatesReference> paymentDatesReferences) {
			if (paymentDatesReferences != null) {
				for (PaymentDatesReference toAdd : paymentDatesReferences) {
					this.paymentDatesReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder setPaymentDatesReference(List<? extends PaymentDatesReference> paymentDatesReferences) {
			if (paymentDatesReferences == null)  {
				this.paymentDatesReference = new ArrayList<>();
			}
			else {
				this.paymentDatesReference = paymentDatesReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DateRelativeToPaymentDates build() {
			return new DateRelativeToPaymentDates.DateRelativeToPaymentDatesImpl(this);
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder prune() {
			paymentDatesReference = paymentDatesReference.stream().filter(b->b!=null).<PaymentDatesReference.PaymentDatesReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentDatesReference()!=null && getPaymentDatesReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder o = (DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPaymentDatesReference(), o.getPaymentDatesReference(), this::getOrCreatePaymentDatesReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToPaymentDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDatesReference, _that.getPaymentDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDatesReference != null ? paymentDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToPaymentDatesBuilder {" +
				"paymentDatesReference=" + this.paymentDatesReference +
			'}';
		}
	}
}
