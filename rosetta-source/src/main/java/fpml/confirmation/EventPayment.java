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
import fpml.confirmation.EventPayment;
import fpml.confirmation.EventPayment.EventPaymentBuilder;
import fpml.confirmation.EventPayment.EventPaymentBuilderImpl;
import fpml.confirmation.EventPayment.EventPaymentImpl;
import fpml.confirmation.EventPaymentSequence;
import fpml.confirmation.Money;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Payment;
import fpml.confirmation.Payment.PaymentBuilder;
import fpml.confirmation.Payment.PaymentBuilderImpl;
import fpml.confirmation.Payment.PaymentImpl;
import fpml.confirmation.PaymentType;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.meta.EventPaymentMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents the prepayment structure associated within a facility.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EventPayment", builder=EventPayment.EventPaymentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EventPayment extends Payment {

	EventPaymentMeta metaData = new EventPaymentMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends EventPaymentSequence> getEventPaymentSequence();

	/*********************** Build Methods  ***********************/
	EventPayment build();
	
	EventPayment.EventPaymentBuilder toBuilder();
	
	static EventPayment.EventPaymentBuilder builder() {
		return new EventPayment.EventPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventPayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventPayment> getType() {
		return EventPayment.class;
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
		processRosetta(path.newSubPath("eventPaymentSequence"), processor, EventPaymentSequence.class, getEventPaymentSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventPaymentBuilder extends EventPayment, Payment.PaymentBuilder {
		EventPaymentSequence.EventPaymentSequenceBuilder getOrCreateEventPaymentSequence(int _index);
		List<? extends EventPaymentSequence.EventPaymentSequenceBuilder> getEventPaymentSequence();
		EventPayment.EventPaymentBuilder setId(String id);
		EventPayment.EventPaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		EventPayment.EventPaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		EventPayment.EventPaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate);
		EventPayment.EventPaymentBuilder setPaymentType(PaymentType paymentType);
		EventPayment.EventPaymentBuilder setSettlementInformation(SettlementInformation settlementInformation);
		EventPayment.EventPaymentBuilder setDiscountFactor(BigDecimal discountFactor);
		EventPayment.EventPaymentBuilder setPresentValueAmount(Money presentValueAmount);
		EventPayment.EventPaymentBuilder setHref(String href);
		EventPayment.EventPaymentBuilder addEventPaymentSequence(EventPaymentSequence eventPaymentSequence0);
		EventPayment.EventPaymentBuilder addEventPaymentSequence(EventPaymentSequence eventPaymentSequence1, int _idx);
		EventPayment.EventPaymentBuilder addEventPaymentSequence(List<? extends EventPaymentSequence> eventPaymentSequence2);
		EventPayment.EventPaymentBuilder setEventPaymentSequence(List<? extends EventPaymentSequence> eventPaymentSequence3);

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
			processRosetta(path.newSubPath("eventPaymentSequence"), processor, EventPaymentSequence.EventPaymentSequenceBuilder.class, getEventPaymentSequence());
		}
		

		EventPayment.EventPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of EventPayment  ***********************/
	class EventPaymentImpl extends Payment.PaymentImpl implements EventPayment {
		private final List<? extends EventPaymentSequence> eventPaymentSequence;
		
		protected EventPaymentImpl(EventPayment.EventPaymentBuilder builder) {
			super(builder);
			this.eventPaymentSequence = ofNullable(builder.getEventPaymentSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventPaymentSequence")
		public List<? extends EventPaymentSequence> getEventPaymentSequence() {
			return eventPaymentSequence;
		}
		
		@Override
		public EventPayment build() {
			return this;
		}
		
		@Override
		public EventPayment.EventPaymentBuilder toBuilder() {
			EventPayment.EventPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventPayment.EventPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEventPaymentSequence()).ifPresent(builder::setEventPaymentSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EventPayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventPaymentSequence, _that.getEventPaymentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventPaymentSequence != null ? eventPaymentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventPayment {" +
				"eventPaymentSequence=" + this.eventPaymentSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EventPayment  ***********************/
	class EventPaymentBuilderImpl extends Payment.PaymentBuilderImpl  implements EventPayment.EventPaymentBuilder {
	
		protected List<EventPaymentSequence.EventPaymentSequenceBuilder> eventPaymentSequence = new ArrayList<>();
	
		public EventPaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventPaymentSequence")
		public List<? extends EventPaymentSequence.EventPaymentSequenceBuilder> getEventPaymentSequence() {
			return eventPaymentSequence;
		}
		
		@Override
		public EventPaymentSequence.EventPaymentSequenceBuilder getOrCreateEventPaymentSequence(int _index) {
		
			if (eventPaymentSequence==null) {
				this.eventPaymentSequence = new ArrayList<>();
			}
			EventPaymentSequence.EventPaymentSequenceBuilder result;
			return getIndex(eventPaymentSequence, _index, () -> {
						EventPaymentSequence.EventPaymentSequenceBuilder newEventPaymentSequence = EventPaymentSequence.builder();
						return newEventPaymentSequence;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public EventPayment.EventPaymentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public EventPayment.EventPaymentBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public EventPayment.EventPaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public EventPayment.EventPaymentBuilder setPaymentDate(AdjustableOrAdjustedDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentType")
		public EventPayment.EventPaymentBuilder setPaymentType(PaymentType paymentType) {
			this.paymentType = paymentType==null?null:paymentType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementInformation")
		public EventPayment.EventPaymentBuilder setSettlementInformation(SettlementInformation settlementInformation) {
			this.settlementInformation = settlementInformation==null?null:settlementInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("discountFactor")
		public EventPayment.EventPaymentBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		@RosettaAttribute("presentValueAmount")
		public EventPayment.EventPaymentBuilder setPresentValueAmount(Money presentValueAmount) {
			this.presentValueAmount = presentValueAmount==null?null:presentValueAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("href")
		public EventPayment.EventPaymentBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		@Override
		@RosettaAttribute("eventPaymentSequence")
		public EventPayment.EventPaymentBuilder addEventPaymentSequence(EventPaymentSequence eventPaymentSequence) {
			if (eventPaymentSequence!=null) this.eventPaymentSequence.add(eventPaymentSequence.toBuilder());
			return this;
		}
		
		@Override
		public EventPayment.EventPaymentBuilder addEventPaymentSequence(EventPaymentSequence eventPaymentSequence, int _idx) {
			getIndex(this.eventPaymentSequence, _idx, () -> eventPaymentSequence.toBuilder());
			return this;
		}
		@Override 
		public EventPayment.EventPaymentBuilder addEventPaymentSequence(List<? extends EventPaymentSequence> eventPaymentSequences) {
			if (eventPaymentSequences != null) {
				for (EventPaymentSequence toAdd : eventPaymentSequences) {
					this.eventPaymentSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EventPayment.EventPaymentBuilder setEventPaymentSequence(List<? extends EventPaymentSequence> eventPaymentSequences) {
			if (eventPaymentSequences == null)  {
				this.eventPaymentSequence = new ArrayList<>();
			}
			else {
				this.eventPaymentSequence = eventPaymentSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public EventPayment build() {
			return new EventPayment.EventPaymentImpl(this);
		}
		
		@Override
		public EventPayment.EventPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventPayment.EventPaymentBuilder prune() {
			super.prune();
			eventPaymentSequence = eventPaymentSequence.stream().filter(b->b!=null).<EventPaymentSequence.EventPaymentSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEventPaymentSequence()!=null && getEventPaymentSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventPayment.EventPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EventPayment.EventPaymentBuilder o = (EventPayment.EventPaymentBuilder) other;
			
			merger.mergeRosetta(getEventPaymentSequence(), o.getEventPaymentSequence(), this::getOrCreateEventPaymentSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EventPayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(eventPaymentSequence, _that.getEventPaymentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventPaymentSequence != null ? eventPaymentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventPaymentBuilder {" +
				"eventPaymentSequence=" + this.eventPaymentSequence +
			'}' + " " + super.toString();
		}
	}
}
