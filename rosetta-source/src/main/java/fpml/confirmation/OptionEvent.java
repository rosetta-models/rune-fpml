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
import fpml.confirmation.AbstractEvent;
import fpml.confirmation.AbstractEvent.AbstractEventBuilder;
import fpml.confirmation.AbstractEvent.AbstractEventBuilderImpl;
import fpml.confirmation.AbstractEvent.AbstractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.KnockOutRateObservation;
import fpml.confirmation.NoTouchRateObservation;
import fpml.confirmation.OptionEvent;
import fpml.confirmation.OptionEvent.OptionEventBuilder;
import fpml.confirmation.OptionEvent.OptionEventBuilderImpl;
import fpml.confirmation.OptionEvent.OptionEventImpl;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.TouchRateObservation;
import fpml.confirmation.Trade;
import fpml.confirmation.TriggerRateObservation;
import fpml.confirmation.meta.OptionEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OptionEvent", builder=OptionEvent.OptionEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OptionEvent extends AbstractEvent {

	OptionEventMeta metaData = new OptionEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Fully describes the original trade (prior to the exercise).
	 */
	Trade getOriginalTrade();
	/**
	 * Identified the trade to which the option event applies.
	 */
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	/**
	 * A structure describing a barrier knock in event
	 */
	TriggerRateObservation getKnockIn();
	/**
	 * A structure describing a barrier knock out event
	 */
	KnockOutRateObservation getKnockOut();
	/**
	 * A structure describing a touch event
	 */
	List<? extends TouchRateObservation> getTouch();
	/**
	 * A structure describing the outcome of an option having no touch events
	 */
	NoTouchRateObservation getNoTouch();

	/*********************** Build Methods  ***********************/
	OptionEvent build();
	
	OptionEvent.OptionEventBuilder toBuilder();
	
	static OptionEvent.OptionEventBuilder builder() {
		return new OptionEvent.OptionEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionEvent> getType() {
		return OptionEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("knockIn"), processor, TriggerRateObservation.class, getKnockIn());
		processRosetta(path.newSubPath("knockOut"), processor, KnockOutRateObservation.class, getKnockOut());
		processRosetta(path.newSubPath("touch"), processor, TouchRateObservation.class, getTouch());
		processRosetta(path.newSubPath("noTouch"), processor, NoTouchRateObservation.class, getNoTouch());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionEventBuilder extends OptionEvent, AbstractEvent.AbstractEventBuilder {
		Trade.TradeBuilder getOrCreateOriginalTrade();
		Trade.TradeBuilder getOriginalTrade();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		TriggerRateObservation.TriggerRateObservationBuilder getOrCreateKnockIn();
		TriggerRateObservation.TriggerRateObservationBuilder getKnockIn();
		KnockOutRateObservation.KnockOutRateObservationBuilder getOrCreateKnockOut();
		KnockOutRateObservation.KnockOutRateObservationBuilder getKnockOut();
		TouchRateObservation.TouchRateObservationBuilder getOrCreateTouch(int _index);
		List<? extends TouchRateObservation.TouchRateObservationBuilder> getTouch();
		NoTouchRateObservation.NoTouchRateObservationBuilder getOrCreateNoTouch();
		NoTouchRateObservation.NoTouchRateObservationBuilder getNoTouch();
		OptionEvent.OptionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		OptionEvent.OptionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		OptionEvent.OptionEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		OptionEvent.OptionEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		OptionEvent.OptionEventBuilder setOriginalTrade(Trade originalTrade);
		OptionEvent.OptionEventBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		OptionEvent.OptionEventBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		OptionEvent.OptionEventBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		OptionEvent.OptionEventBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		OptionEvent.OptionEventBuilder setKnockIn(TriggerRateObservation knockIn);
		OptionEvent.OptionEventBuilder setKnockOut(KnockOutRateObservation knockOut);
		OptionEvent.OptionEventBuilder addTouch(TouchRateObservation touch0);
		OptionEvent.OptionEventBuilder addTouch(TouchRateObservation touch1, int _idx);
		OptionEvent.OptionEventBuilder addTouch(List<? extends TouchRateObservation> touch2);
		OptionEvent.OptionEventBuilder setTouch(List<? extends TouchRateObservation> touch3);
		OptionEvent.OptionEventBuilder setNoTouch(NoTouchRateObservation noTouch);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("knockIn"), processor, TriggerRateObservation.TriggerRateObservationBuilder.class, getKnockIn());
			processRosetta(path.newSubPath("knockOut"), processor, KnockOutRateObservation.KnockOutRateObservationBuilder.class, getKnockOut());
			processRosetta(path.newSubPath("touch"), processor, TouchRateObservation.TouchRateObservationBuilder.class, getTouch());
			processRosetta(path.newSubPath("noTouch"), processor, NoTouchRateObservation.NoTouchRateObservationBuilder.class, getNoTouch());
		}
		

		OptionEvent.OptionEventBuilder prune();
	}

	/*********************** Immutable Implementation of OptionEvent  ***********************/
	class OptionEventImpl extends AbstractEvent.AbstractEventImpl implements OptionEvent {
		private final Trade originalTrade;
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final TriggerRateObservation knockIn;
		private final KnockOutRateObservation knockOut;
		private final List<? extends TouchRateObservation> touch;
		private final NoTouchRateObservation noTouch;
		
		protected OptionEventImpl(OptionEvent.OptionEventBuilder builder) {
			super(builder);
			this.originalTrade = ofNullable(builder.getOriginalTrade()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.knockIn = ofNullable(builder.getKnockIn()).map(f->f.build()).orElse(null);
			this.knockOut = ofNullable(builder.getKnockOut()).map(f->f.build()).orElse(null);
			this.touch = ofNullable(builder.getTouch()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.noTouch = ofNullable(builder.getNoTouch()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		public Trade getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("knockIn")
		public TriggerRateObservation getKnockIn() {
			return knockIn;
		}
		
		@Override
		@RosettaAttribute("knockOut")
		public KnockOutRateObservation getKnockOut() {
			return knockOut;
		}
		
		@Override
		@RosettaAttribute("touch")
		public List<? extends TouchRateObservation> getTouch() {
			return touch;
		}
		
		@Override
		@RosettaAttribute("noTouch")
		public NoTouchRateObservation getNoTouch() {
			return noTouch;
		}
		
		@Override
		public OptionEvent build() {
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder toBuilder() {
			OptionEvent.OptionEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionEvent.OptionEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOriginalTrade()).ifPresent(builder::setOriginalTrade);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getKnockIn()).ifPresent(builder::setKnockIn);
			ofNullable(getKnockOut()).ifPresent(builder::setKnockOut);
			ofNullable(getTouch()).ifPresent(builder::setTouch);
			ofNullable(getNoTouch()).ifPresent(builder::setNoTouch);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionEvent _that = getType().cast(o);
		
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(knockIn, _that.getKnockIn())) return false;
			if (!Objects.equals(knockOut, _that.getKnockOut())) return false;
			if (!ListEquals.listEquals(touch, _that.getTouch())) return false;
			if (!Objects.equals(noTouch, _that.getNoTouch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (knockIn != null ? knockIn.hashCode() : 0);
			_result = 31 * _result + (knockOut != null ? knockOut.hashCode() : 0);
			_result = 31 * _result + (touch != null ? touch.hashCode() : 0);
			_result = 31 * _result + (noTouch != null ? noTouch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionEvent {" +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"knockIn=" + this.knockIn + ", " +
				"knockOut=" + this.knockOut + ", " +
				"touch=" + this.touch + ", " +
				"noTouch=" + this.noTouch +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionEvent  ***********************/
	class OptionEventBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl  implements OptionEvent.OptionEventBuilder {
	
		protected Trade.TradeBuilder originalTrade;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected TriggerRateObservation.TriggerRateObservationBuilder knockIn;
		protected KnockOutRateObservation.KnockOutRateObservationBuilder knockOut;
		protected List<TouchRateObservation.TouchRateObservationBuilder> touch = new ArrayList<>();
		protected NoTouchRateObservation.NoTouchRateObservationBuilder noTouch;
	
		public OptionEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("originalTrade")
		public Trade.TradeBuilder getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOriginalTrade() {
			Trade.TradeBuilder result;
			if (originalTrade!=null) {
				result = originalTrade;
			}
			else {
				result = originalTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("knockIn")
		public TriggerRateObservation.TriggerRateObservationBuilder getKnockIn() {
			return knockIn;
		}
		
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder getOrCreateKnockIn() {
			TriggerRateObservation.TriggerRateObservationBuilder result;
			if (knockIn!=null) {
				result = knockIn;
			}
			else {
				result = knockIn = TriggerRateObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knockOut")
		public KnockOutRateObservation.KnockOutRateObservationBuilder getKnockOut() {
			return knockOut;
		}
		
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder getOrCreateKnockOut() {
			KnockOutRateObservation.KnockOutRateObservationBuilder result;
			if (knockOut!=null) {
				result = knockOut;
			}
			else {
				result = knockOut = KnockOutRateObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("touch")
		public List<? extends TouchRateObservation.TouchRateObservationBuilder> getTouch() {
			return touch;
		}
		
		@Override
		public TouchRateObservation.TouchRateObservationBuilder getOrCreateTouch(int _index) {
		
			if (touch==null) {
				this.touch = new ArrayList<>();
			}
			TouchRateObservation.TouchRateObservationBuilder result;
			return getIndex(touch, _index, () -> {
						TouchRateObservation.TouchRateObservationBuilder newTouch = TouchRateObservation.builder();
						return newTouch;
					});
		}
		
		@Override
		@RosettaAttribute("noTouch")
		public NoTouchRateObservation.NoTouchRateObservationBuilder getNoTouch() {
			return noTouch;
		}
		
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder getOrCreateNoTouch() {
			NoTouchRateObservation.NoTouchRateObservationBuilder result;
			if (noTouch!=null) {
				result = noTouch;
			}
			else {
				result = noTouch = NoTouchRateObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public OptionEvent.OptionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public OptionEvent.OptionEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionEvent.OptionEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		public OptionEvent.OptionEventBuilder setOriginalTrade(Trade originalTrade) {
			this.originalTrade = originalTrade==null?null:originalTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifier")
		public OptionEvent.OptionEventBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public OptionEvent.OptionEventBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionEvent.OptionEventBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("knockIn")
		public OptionEvent.OptionEventBuilder setKnockIn(TriggerRateObservation knockIn) {
			this.knockIn = knockIn==null?null:knockIn.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("knockOut")
		public OptionEvent.OptionEventBuilder setKnockOut(KnockOutRateObservation knockOut) {
			this.knockOut = knockOut==null?null:knockOut.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("touch")
		public OptionEvent.OptionEventBuilder addTouch(TouchRateObservation touch) {
			if (touch!=null) this.touch.add(touch.toBuilder());
			return this;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder addTouch(TouchRateObservation touch, int _idx) {
			getIndex(this.touch, _idx, () -> touch.toBuilder());
			return this;
		}
		@Override 
		public OptionEvent.OptionEventBuilder addTouch(List<? extends TouchRateObservation> touchs) {
			if (touchs != null) {
				for (TouchRateObservation toAdd : touchs) {
					this.touch.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionEvent.OptionEventBuilder setTouch(List<? extends TouchRateObservation> touchs) {
			if (touchs == null)  {
				this.touch = new ArrayList<>();
			}
			else {
				this.touch = touchs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("noTouch")
		public OptionEvent.OptionEventBuilder setNoTouch(NoTouchRateObservation noTouch) {
			this.noTouch = noTouch==null?null:noTouch.toBuilder();
			return this;
		}
		
		@Override
		public OptionEvent build() {
			return new OptionEvent.OptionEventImpl(this);
		}
		
		@Override
		public OptionEvent.OptionEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionEvent.OptionEventBuilder prune() {
			super.prune();
			if (originalTrade!=null && !originalTrade.prune().hasData()) originalTrade = null;
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (knockIn!=null && !knockIn.prune().hasData()) knockIn = null;
			if (knockOut!=null && !knockOut.prune().hasData()) knockOut = null;
			touch = touch.stream().filter(b->b!=null).<TouchRateObservation.TouchRateObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (noTouch!=null && !noTouch.prune().hasData()) noTouch = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOriginalTrade()!=null && getOriginalTrade().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getKnockIn()!=null && getKnockIn().hasData()) return true;
			if (getKnockOut()!=null && getKnockOut().hasData()) return true;
			if (getTouch()!=null && getTouch().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNoTouch()!=null && getNoTouch().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionEvent.OptionEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionEvent.OptionEventBuilder o = (OptionEvent.OptionEventBuilder) other;
			
			merger.mergeRosetta(getOriginalTrade(), o.getOriginalTrade(), this::setOriginalTrade);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getKnockIn(), o.getKnockIn(), this::setKnockIn);
			merger.mergeRosetta(getKnockOut(), o.getKnockOut(), this::setKnockOut);
			merger.mergeRosetta(getTouch(), o.getTouch(), this::getOrCreateTouch);
			merger.mergeRosetta(getNoTouch(), o.getNoTouch(), this::setNoTouch);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionEvent _that = getType().cast(o);
		
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(knockIn, _that.getKnockIn())) return false;
			if (!Objects.equals(knockOut, _that.getKnockOut())) return false;
			if (!ListEquals.listEquals(touch, _that.getTouch())) return false;
			if (!Objects.equals(noTouch, _that.getNoTouch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (knockIn != null ? knockIn.hashCode() : 0);
			_result = 31 * _result + (knockOut != null ? knockOut.hashCode() : 0);
			_result = 31 * _result + (touch != null ? touch.hashCode() : 0);
			_result = 31 * _result + (noTouch != null ? noTouch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionEventBuilder {" +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"knockIn=" + this.knockIn + ", " +
				"knockOut=" + this.knockOut + ", " +
				"touch=" + this.touch + ", " +
				"noTouch=" + this.noTouch +
			'}' + " " + super.toString();
		}
	}
}
