package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.FxDisruptionEvent;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventBuilder;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventBuilderImpl;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventImpl;
import fpml.confirmation.meta.FxDisruptionEventMeta;


/**
 * The abstract element used to create the extendible set of disruption events The base class for all disruption events
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxDisruptionEvent", builder=FxDisruptionEvent.FxDisruptionEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxDisruptionEvent extends RosettaModelObject {

	FxDisruptionEventMeta metaData = new FxDisruptionEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxDisruptionEvent build();
	
	FxDisruptionEvent.FxDisruptionEventBuilder toBuilder();
	
	static FxDisruptionEvent.FxDisruptionEventBuilder builder() {
		return new FxDisruptionEvent.FxDisruptionEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDisruptionEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDisruptionEvent> getType() {
		return FxDisruptionEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDisruptionEventBuilder extends FxDisruptionEvent, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		FxDisruptionEvent.FxDisruptionEventBuilder prune();
	}

	/*********************** Immutable Implementation of FxDisruptionEvent  ***********************/
	class FxDisruptionEventImpl implements FxDisruptionEvent {
		
		protected FxDisruptionEventImpl(FxDisruptionEvent.FxDisruptionEventBuilder builder) {
		}
		
		@Override
		public FxDisruptionEvent build() {
			return this;
		}
		
		@Override
		public FxDisruptionEvent.FxDisruptionEventBuilder toBuilder() {
			FxDisruptionEvent.FxDisruptionEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDisruptionEvent.FxDisruptionEventBuilder builder) {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionEvent {" +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDisruptionEvent  ***********************/
	class FxDisruptionEventBuilderImpl implements FxDisruptionEvent.FxDisruptionEventBuilder {
	
	
		public FxDisruptionEventBuilderImpl() {
		}
	
		
		@Override
		public FxDisruptionEvent build() {
			return new FxDisruptionEvent.FxDisruptionEventImpl(this);
		}
		
		@Override
		public FxDisruptionEvent.FxDisruptionEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionEvent.FxDisruptionEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionEvent.FxDisruptionEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDisruptionEvent.FxDisruptionEventBuilder o = (FxDisruptionEvent.FxDisruptionEventBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionEventBuilder {" +
			'}';
		}
	}
}
