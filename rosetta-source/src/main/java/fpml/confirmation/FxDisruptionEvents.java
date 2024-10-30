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
import fpml.confirmation.FxDisruptionEvent;
import fpml.confirmation.FxDisruptionEvents;
import fpml.confirmation.FxDisruptionEvents.FxDisruptionEventsBuilder;
import fpml.confirmation.FxDisruptionEvents.FxDisruptionEventsBuilderImpl;
import fpml.confirmation.FxDisruptionEvents.FxDisruptionEventsImpl;
import fpml.confirmation.meta.FxDisruptionEventsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A container for the disruption event set
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxDisruptionEvents", builder=FxDisruptionEvents.FxDisruptionEventsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxDisruptionEvents extends RosettaModelObject {

	FxDisruptionEventsMeta metaData = new FxDisruptionEventsMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends FxDisruptionEvent> getFxDisruptionEvent();

	/*********************** Build Methods  ***********************/
	FxDisruptionEvents build();
	
	FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder();
	
	static FxDisruptionEvents.FxDisruptionEventsBuilder builder() {
		return new FxDisruptionEvents.FxDisruptionEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDisruptionEvents> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDisruptionEvents> getType() {
		return FxDisruptionEvents.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxDisruptionEvent"), processor, FxDisruptionEvent.class, getFxDisruptionEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDisruptionEventsBuilder extends FxDisruptionEvents, RosettaModelObjectBuilder {
		FxDisruptionEvent.FxDisruptionEventBuilder getOrCreateFxDisruptionEvent(int _index);
		List<? extends FxDisruptionEvent.FxDisruptionEventBuilder> getFxDisruptionEvent();
		FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(FxDisruptionEvent fxDisruptionEvent0);
		FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(FxDisruptionEvent fxDisruptionEvent1, int _idx);
		FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(List<? extends FxDisruptionEvent> fxDisruptionEvent2);
		FxDisruptionEvents.FxDisruptionEventsBuilder setFxDisruptionEvent(List<? extends FxDisruptionEvent> fxDisruptionEvent3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxDisruptionEvent"), processor, FxDisruptionEvent.FxDisruptionEventBuilder.class, getFxDisruptionEvent());
		}
		

		FxDisruptionEvents.FxDisruptionEventsBuilder prune();
	}

	/*********************** Immutable Implementation of FxDisruptionEvents  ***********************/
	class FxDisruptionEventsImpl implements FxDisruptionEvents {
		private final List<? extends FxDisruptionEvent> fxDisruptionEvent;
		
		protected FxDisruptionEventsImpl(FxDisruptionEvents.FxDisruptionEventsBuilder builder) {
			this.fxDisruptionEvent = ofNullable(builder.getFxDisruptionEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxDisruptionEvent")
		public List<? extends FxDisruptionEvent> getFxDisruptionEvent() {
			return fxDisruptionEvent;
		}
		
		@Override
		public FxDisruptionEvents build() {
			return this;
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder() {
			FxDisruptionEvents.FxDisruptionEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDisruptionEvents.FxDisruptionEventsBuilder builder) {
			ofNullable(getFxDisruptionEvent()).ifPresent(builder::setFxDisruptionEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionEvents _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fxDisruptionEvent, _that.getFxDisruptionEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxDisruptionEvent != null ? fxDisruptionEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionEvents {" +
				"fxDisruptionEvent=" + this.fxDisruptionEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDisruptionEvents  ***********************/
	class FxDisruptionEventsBuilderImpl implements FxDisruptionEvents.FxDisruptionEventsBuilder {
	
		protected List<FxDisruptionEvent.FxDisruptionEventBuilder> fxDisruptionEvent = new ArrayList<>();
	
		public FxDisruptionEventsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxDisruptionEvent")
		public List<? extends FxDisruptionEvent.FxDisruptionEventBuilder> getFxDisruptionEvent() {
			return fxDisruptionEvent;
		}
		
		@Override
		public FxDisruptionEvent.FxDisruptionEventBuilder getOrCreateFxDisruptionEvent(int _index) {
		
			if (fxDisruptionEvent==null) {
				this.fxDisruptionEvent = new ArrayList<>();
			}
			FxDisruptionEvent.FxDisruptionEventBuilder result;
			return getIndex(fxDisruptionEvent, _index, () -> {
						FxDisruptionEvent.FxDisruptionEventBuilder newFxDisruptionEvent = FxDisruptionEvent.builder();
						return newFxDisruptionEvent;
					});
		}
		
		@Override
		@RosettaAttribute("fxDisruptionEvent")
		public FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(FxDisruptionEvent fxDisruptionEvent) {
			if (fxDisruptionEvent!=null) this.fxDisruptionEvent.add(fxDisruptionEvent.toBuilder());
			return this;
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(FxDisruptionEvent fxDisruptionEvent, int _idx) {
			getIndex(this.fxDisruptionEvent, _idx, () -> fxDisruptionEvent.toBuilder());
			return this;
		}
		@Override 
		public FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(List<? extends FxDisruptionEvent> fxDisruptionEvents) {
			if (fxDisruptionEvents != null) {
				for (FxDisruptionEvent toAdd : fxDisruptionEvents) {
					this.fxDisruptionEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxDisruptionEvents.FxDisruptionEventsBuilder setFxDisruptionEvent(List<? extends FxDisruptionEvent> fxDisruptionEvents) {
			if (fxDisruptionEvents == null)  {
				this.fxDisruptionEvent = new ArrayList<>();
			}
			else {
				this.fxDisruptionEvent = fxDisruptionEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxDisruptionEvents build() {
			return new FxDisruptionEvents.FxDisruptionEventsImpl(this);
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder prune() {
			fxDisruptionEvent = fxDisruptionEvent.stream().filter(b->b!=null).<FxDisruptionEvent.FxDisruptionEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxDisruptionEvent()!=null && getFxDisruptionEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDisruptionEvents.FxDisruptionEventsBuilder o = (FxDisruptionEvents.FxDisruptionEventsBuilder) other;
			
			merger.mergeRosetta(getFxDisruptionEvent(), o.getFxDisruptionEvent(), this::getOrCreateFxDisruptionEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionEvents _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fxDisruptionEvent, _that.getFxDisruptionEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxDisruptionEvent != null ? fxDisruptionEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionEventsBuilder {" +
				"fxDisruptionEvent=" + this.fxDisruptionEvent +
			'}';
		}
	}
}
