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
import fpml.confirmation.AbstractEvent;
import fpml.confirmation.AbstractEvent.AbstractEventBuilder;
import fpml.confirmation.AbstractEvent.AbstractEventBuilderImpl;
import fpml.confirmation.AbstractEvent.AbstractEventImpl;
import fpml.confirmation.ActionOnExpiration;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.ExerciseProcedureOption;
import fpml.confirmation.OptionExpiry;
import fpml.confirmation.OptionExpiry.OptionExpiryBuilder;
import fpml.confirmation.OptionExpiry.OptionExpiryBuilderImpl;
import fpml.confirmation.OptionExpiry.OptionExpiryImpl;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;
import fpml.confirmation.meta.OptionExpiryMeta;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing an option expiring (i.e. passing its last exercise time and becoming worthless.)
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="OptionExpiry", builder=OptionExpiry.OptionExpiryBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface OptionExpiry extends AbstractEvent {

	OptionExpiryMeta metaData = new OptionExpiryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Fully describes the original trade (prior to the exercise).
	 */
	Trade getOriginalTrade();
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	Date getDate();
	LocalTime getTime();
	ExerciseProcedureOption getExerciseProcedure();
	ActionOnExpiration getActionOnExpiration();

	/*********************** Build Methods  ***********************/
	OptionExpiry build();
	
	OptionExpiry.OptionExpiryBuilder toBuilder();
	
	static OptionExpiry.OptionExpiryBuilder builder() {
		return new OptionExpiry.OptionExpiryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExpiry> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExpiry> getType() {
		return OptionExpiry.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedureOption.class, getExerciseProcedure());
		processRosetta(path.newSubPath("actionOnExpiration"), processor, ActionOnExpiration.class, getActionOnExpiration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExpiryBuilder extends OptionExpiry, AbstractEvent.AbstractEventBuilder {
		Trade.TradeBuilder getOrCreateOriginalTrade();
		Trade.TradeBuilder getOriginalTrade();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		ExerciseProcedureOption.ExerciseProcedureOptionBuilder getOrCreateExerciseProcedure();
		ExerciseProcedureOption.ExerciseProcedureOptionBuilder getExerciseProcedure();
		ActionOnExpiration.ActionOnExpirationBuilder getOrCreateActionOnExpiration();
		ActionOnExpiration.ActionOnExpirationBuilder getActionOnExpiration();
		OptionExpiry.OptionExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		OptionExpiry.OptionExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		OptionExpiry.OptionExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		OptionExpiry.OptionExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		OptionExpiry.OptionExpiryBuilder setOriginalTrade(Trade originalTrade);
		OptionExpiry.OptionExpiryBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		OptionExpiry.OptionExpiryBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		OptionExpiry.OptionExpiryBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		OptionExpiry.OptionExpiryBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		OptionExpiry.OptionExpiryBuilder setDate(Date date);
		OptionExpiry.OptionExpiryBuilder setTime(LocalTime time);
		OptionExpiry.OptionExpiryBuilder setExerciseProcedure(ExerciseProcedureOption exerciseProcedure);
		OptionExpiry.OptionExpiryBuilder setActionOnExpiration(ActionOnExpiration actionOnExpiration);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedureOption.ExerciseProcedureOptionBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("actionOnExpiration"), processor, ActionOnExpiration.ActionOnExpirationBuilder.class, getActionOnExpiration());
		}
		

		OptionExpiry.OptionExpiryBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExpiry  ***********************/
	class OptionExpiryImpl extends AbstractEvent.AbstractEventImpl implements OptionExpiry {
		private final Trade originalTrade;
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final Date date;
		private final LocalTime time;
		private final ExerciseProcedureOption exerciseProcedure;
		private final ActionOnExpiration actionOnExpiration;
		
		protected OptionExpiryImpl(OptionExpiry.OptionExpiryBuilder builder) {
			super(builder);
			this.originalTrade = ofNullable(builder.getOriginalTrade()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.date = builder.getDate();
			this.time = builder.getTime();
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.actionOnExpiration = ofNullable(builder.getActionOnExpiration()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedureOption getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("actionOnExpiration")
		public ActionOnExpiration getActionOnExpiration() {
			return actionOnExpiration;
		}
		
		@Override
		public OptionExpiry build() {
			return this;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder toBuilder() {
			OptionExpiry.OptionExpiryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExpiry.OptionExpiryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOriginalTrade()).ifPresent(builder::setOriginalTrade);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getActionOnExpiration()).ifPresent(builder::setActionOnExpiration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionExpiry _that = getType().cast(o);
		
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(actionOnExpiration, _that.getActionOnExpiration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (actionOnExpiration != null ? actionOnExpiration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpiry {" +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"actionOnExpiration=" + this.actionOnExpiration +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionExpiry  ***********************/
	class OptionExpiryBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl  implements OptionExpiry.OptionExpiryBuilder {
	
		protected Trade.TradeBuilder originalTrade;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Date date;
		protected LocalTime time;
		protected ExerciseProcedureOption.ExerciseProcedureOptionBuilder exerciseProcedure;
		protected ActionOnExpiration.ActionOnExpirationBuilder actionOnExpiration;
	
		public OptionExpiryBuilderImpl() {
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
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedureOption.ExerciseProcedureOptionBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedureOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("actionOnExpiration")
		public ActionOnExpiration.ActionOnExpirationBuilder getActionOnExpiration() {
			return actionOnExpiration;
		}
		
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder getOrCreateActionOnExpiration() {
			ActionOnExpiration.ActionOnExpirationBuilder result;
			if (actionOnExpiration!=null) {
				result = actionOnExpiration;
			}
			else {
				result = actionOnExpiration = ActionOnExpiration.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public OptionExpiry.OptionExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public OptionExpiry.OptionExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionExpiry.OptionExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public OptionExpiry.OptionExpiryBuilder setOriginalTrade(Trade originalTrade) {
			this.originalTrade = originalTrade==null?null:originalTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifier")
		public OptionExpiry.OptionExpiryBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public OptionExpiry.OptionExpiryBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionExpiry.OptionExpiryBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
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
		@RosettaAttribute("date")
		public OptionExpiry.OptionExpiryBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("time")
		public OptionExpiry.OptionExpiryBuilder setTime(LocalTime time) {
			this.time = time==null?null:time;
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public OptionExpiry.OptionExpiryBuilder setExerciseProcedure(ExerciseProcedureOption exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("actionOnExpiration")
		public OptionExpiry.OptionExpiryBuilder setActionOnExpiration(ActionOnExpiration actionOnExpiration) {
			this.actionOnExpiration = actionOnExpiration==null?null:actionOnExpiration.toBuilder();
			return this;
		}
		
		@Override
		public OptionExpiry build() {
			return new OptionExpiry.OptionExpiryImpl(this);
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpiry.OptionExpiryBuilder prune() {
			super.prune();
			if (originalTrade!=null && !originalTrade.prune().hasData()) originalTrade = null;
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (actionOnExpiration!=null && !actionOnExpiration.prune().hasData()) actionOnExpiration = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOriginalTrade()!=null && getOriginalTrade().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getActionOnExpiration()!=null && getActionOnExpiration().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpiry.OptionExpiryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionExpiry.OptionExpiryBuilder o = (OptionExpiry.OptionExpiryBuilder) other;
			
			merger.mergeRosetta(getOriginalTrade(), o.getOriginalTrade(), this::setOriginalTrade);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getActionOnExpiration(), o.getActionOnExpiration(), this::setActionOnExpiration);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionExpiry _that = getType().cast(o);
		
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(actionOnExpiration, _that.getActionOnExpiration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (actionOnExpiration != null ? actionOnExpiration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpiryBuilder {" +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"actionOnExpiration=" + this.actionOnExpiration +
			'}' + " " + super.toString();
		}
	}
}
