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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.ChangeEvent;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Payment;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeChangeContent;
import fpml.confirmation.TradeChangeContent.TradeChangeContentBuilder;
import fpml.confirmation.TradeChangeContent.TradeChangeContentBuilderImpl;
import fpml.confirmation.TradeChangeContent.TradeChangeContentImpl;
import fpml.confirmation.meta.TradeChangeContentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a non-negotiated trade resulting from a market event.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeChangeContent", builder=TradeChangeContent.TradeChangeContentBuilderImpl.class, version="${project.version}")
public interface TradeChangeContent extends RosettaModelObject {

	TradeChangeContentMeta metaData = new TradeChangeContentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The original qualified trade identifier.
	 */
	PartyTradeIdentifier getOldTradeIdentifier();
	/**
	 * The original trade details.
	 */
	Trade getOldTrade();
	/**
	 * A full description of the amended trade.
	 */
	Trade getTrade();
	/**
	 * The date on which the change become effective
	 */
	Date getEffectiveDate();
	ChangeEvent getChangeEvent();
	/**
	 * Describes a payment made in settlement of the change.
	 */
	Payment getPayment();

	/*********************** Build Methods  ***********************/
	TradeChangeContent build();
	
	TradeChangeContent.TradeChangeContentBuilder toBuilder();
	
	static TradeChangeContent.TradeChangeContentBuilder builder() {
		return new TradeChangeContent.TradeChangeContentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeContent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeChangeContent> getType() {
		return TradeChangeContent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("oldTradeIdentifier"), processor, PartyTradeIdentifier.class, getOldTradeIdentifier());
		processRosetta(path.newSubPath("oldTrade"), processor, Trade.class, getOldTrade());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("changeEvent"), processor, ChangeEvent.class, getChangeEvent());
		processRosetta(path.newSubPath("payment"), processor, Payment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeChangeContentBuilder extends TradeChangeContent, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateOldTradeIdentifier();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOldTradeIdentifier();
		Trade.TradeBuilder getOrCreateOldTrade();
		Trade.TradeBuilder getOldTrade();
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		ChangeEvent.ChangeEventBuilder getOrCreateChangeEvent();
		ChangeEvent.ChangeEventBuilder getChangeEvent();
		Payment.PaymentBuilder getOrCreatePayment();
		Payment.PaymentBuilder getPayment();
		TradeChangeContent.TradeChangeContentBuilder setOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier);
		TradeChangeContent.TradeChangeContentBuilder setOldTrade(Trade oldTrade);
		TradeChangeContent.TradeChangeContentBuilder setTrade(Trade trade);
		TradeChangeContent.TradeChangeContentBuilder setEffectiveDate(Date effectiveDate);
		TradeChangeContent.TradeChangeContentBuilder setChangeEvent(ChangeEvent changeEvent);
		TradeChangeContent.TradeChangeContentBuilder setPayment(Payment payment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("oldTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getOldTradeIdentifier());
			processRosetta(path.newSubPath("oldTrade"), processor, Trade.TradeBuilder.class, getOldTrade());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("changeEvent"), processor, ChangeEvent.ChangeEventBuilder.class, getChangeEvent());
			processRosetta(path.newSubPath("payment"), processor, Payment.PaymentBuilder.class, getPayment());
		}
		

		TradeChangeContent.TradeChangeContentBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeContent  ***********************/
	class TradeChangeContentImpl implements TradeChangeContent {
		private final PartyTradeIdentifier oldTradeIdentifier;
		private final Trade oldTrade;
		private final Trade trade;
		private final Date effectiveDate;
		private final ChangeEvent changeEvent;
		private final Payment payment;
		
		protected TradeChangeContentImpl(TradeChangeContent.TradeChangeContentBuilder builder) {
			this.oldTradeIdentifier = ofNullable(builder.getOldTradeIdentifier()).map(f->f.build()).orElse(null);
			this.oldTrade = ofNullable(builder.getOldTrade()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.changeEvent = ofNullable(builder.getChangeEvent()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		public PartyTradeIdentifier getOldTradeIdentifier() {
			return oldTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		public Trade getOldTrade() {
			return oldTrade;
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("changeEvent")
		public ChangeEvent getChangeEvent() {
			return changeEvent;
		}
		
		@Override
		@RosettaAttribute("payment")
		public Payment getPayment() {
			return payment;
		}
		
		@Override
		public TradeChangeContent build() {
			return this;
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder toBuilder() {
			TradeChangeContent.TradeChangeContentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeContent.TradeChangeContentBuilder builder) {
			ofNullable(getOldTradeIdentifier()).ifPresent(builder::setOldTradeIdentifier);
			ofNullable(getOldTrade()).ifPresent(builder::setOldTrade);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getChangeEvent()).ifPresent(builder::setChangeEvent);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeChangeContent _that = getType().cast(o);
		
			if (!Objects.equals(oldTradeIdentifier, _that.getOldTradeIdentifier())) return false;
			if (!Objects.equals(oldTrade, _that.getOldTrade())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(changeEvent, _that.getChangeEvent())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (oldTradeIdentifier != null ? oldTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (oldTrade != null ? oldTrade.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (changeEvent != null ? changeEvent.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeContent {" +
				"oldTradeIdentifier=" + this.oldTradeIdentifier + ", " +
				"oldTrade=" + this.oldTrade + ", " +
				"trade=" + this.trade + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"changeEvent=" + this.changeEvent + ", " +
				"payment=" + this.payment +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeChangeContent  ***********************/
	class TradeChangeContentBuilderImpl implements TradeChangeContent.TradeChangeContentBuilder {
	
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder oldTradeIdentifier;
		protected Trade.TradeBuilder oldTrade;
		protected Trade.TradeBuilder trade;
		protected Date effectiveDate;
		protected ChangeEvent.ChangeEventBuilder changeEvent;
		protected Payment.PaymentBuilder payment;
	
		public TradeChangeContentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOldTradeIdentifier() {
			return oldTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateOldTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (oldTradeIdentifier!=null) {
				result = oldTradeIdentifier;
			}
			else {
				result = oldTradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oldTrade")
		public Trade.TradeBuilder getOldTrade() {
			return oldTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOldTrade() {
			Trade.TradeBuilder result;
			if (oldTrade!=null) {
				result = oldTrade;
			}
			else {
				result = oldTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("changeEvent")
		public ChangeEvent.ChangeEventBuilder getChangeEvent() {
			return changeEvent;
		}
		
		@Override
		public ChangeEvent.ChangeEventBuilder getOrCreateChangeEvent() {
			ChangeEvent.ChangeEventBuilder result;
			if (changeEvent!=null) {
				result = changeEvent;
			}
			else {
				result = changeEvent = ChangeEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		public Payment.PaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePayment() {
			Payment.PaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = Payment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oldTradeIdentifier")
		public TradeChangeContent.TradeChangeContentBuilder setOldTradeIdentifier(PartyTradeIdentifier oldTradeIdentifier) {
			this.oldTradeIdentifier = oldTradeIdentifier==null?null:oldTradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("oldTrade")
		public TradeChangeContent.TradeChangeContentBuilder setOldTrade(Trade oldTrade) {
			this.oldTrade = oldTrade==null?null:oldTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public TradeChangeContent.TradeChangeContentBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public TradeChangeContent.TradeChangeContentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("changeEvent")
		public TradeChangeContent.TradeChangeContentBuilder setChangeEvent(ChangeEvent changeEvent) {
			this.changeEvent = changeEvent==null?null:changeEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payment")
		public TradeChangeContent.TradeChangeContentBuilder setPayment(Payment payment) {
			this.payment = payment==null?null:payment.toBuilder();
			return this;
		}
		
		@Override
		public TradeChangeContent build() {
			return new TradeChangeContent.TradeChangeContentImpl(this);
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder prune() {
			if (oldTradeIdentifier!=null && !oldTradeIdentifier.prune().hasData()) oldTradeIdentifier = null;
			if (oldTrade!=null && !oldTrade.prune().hasData()) oldTrade = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (changeEvent!=null && !changeEvent.prune().hasData()) changeEvent = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOldTradeIdentifier()!=null && getOldTradeIdentifier().hasData()) return true;
			if (getOldTrade()!=null && getOldTrade().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getChangeEvent()!=null && getChangeEvent().hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeContent.TradeChangeContentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeChangeContent.TradeChangeContentBuilder o = (TradeChangeContent.TradeChangeContentBuilder) other;
			
			merger.mergeRosetta(getOldTradeIdentifier(), o.getOldTradeIdentifier(), this::setOldTradeIdentifier);
			merger.mergeRosetta(getOldTrade(), o.getOldTrade(), this::setOldTrade);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getChangeEvent(), o.getChangeEvent(), this::setChangeEvent);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeChangeContent _that = getType().cast(o);
		
			if (!Objects.equals(oldTradeIdentifier, _that.getOldTradeIdentifier())) return false;
			if (!Objects.equals(oldTrade, _that.getOldTrade())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(changeEvent, _that.getChangeEvent())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (oldTradeIdentifier != null ? oldTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (oldTrade != null ? oldTrade.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (changeEvent != null ? changeEvent.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeContentBuilder {" +
				"oldTradeIdentifier=" + this.oldTradeIdentifier + ", " +
				"oldTrade=" + this.oldTrade + ", " +
				"trade=" + this.trade + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"changeEvent=" + this.changeEvent + ", " +
				"payment=" + this.payment +
			'}';
		}
	}
}
