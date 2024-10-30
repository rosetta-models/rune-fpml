package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CreditEvent;
import fpml.confirmation.CreditEvent.CreditEventBuilder;
import fpml.confirmation.CreditEvent.CreditEventBuilderImpl;
import fpml.confirmation.CreditEvent.CreditEventImpl;
import fpml.confirmation.ObligationAccelerationEvent;
import fpml.confirmation.ObligationAccelerationEvent.ObligationAccelerationEventBuilder;
import fpml.confirmation.ObligationAccelerationEvent.ObligationAccelerationEventBuilderImpl;
import fpml.confirmation.ObligationAccelerationEvent.ObligationAccelerationEventImpl;
import fpml.confirmation.meta.ObligationAccelerationEventMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ObligationAccelerationEvent", builder=ObligationAccelerationEvent.ObligationAccelerationEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ObligationAccelerationEvent extends CreditEvent {

	ObligationAccelerationEventMeta metaData = new ObligationAccelerationEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ObligationAccelerationEvent build();
	
	ObligationAccelerationEvent.ObligationAccelerationEventBuilder toBuilder();
	
	static ObligationAccelerationEvent.ObligationAccelerationEventBuilder builder() {
		return new ObligationAccelerationEvent.ObligationAccelerationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObligationAccelerationEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObligationAccelerationEvent> getType() {
		return ObligationAccelerationEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObligationAccelerationEventBuilder extends ObligationAccelerationEvent, CreditEvent.CreditEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		ObligationAccelerationEvent.ObligationAccelerationEventBuilder prune();
	}

	/*********************** Immutable Implementation of ObligationAccelerationEvent  ***********************/
	class ObligationAccelerationEventImpl extends CreditEvent.CreditEventImpl implements ObligationAccelerationEvent {
		
		protected ObligationAccelerationEventImpl(ObligationAccelerationEvent.ObligationAccelerationEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public ObligationAccelerationEvent build() {
			return this;
		}
		
		@Override
		public ObligationAccelerationEvent.ObligationAccelerationEventBuilder toBuilder() {
			ObligationAccelerationEvent.ObligationAccelerationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObligationAccelerationEvent.ObligationAccelerationEventBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObligationAccelerationEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObligationAccelerationEvent  ***********************/
	class ObligationAccelerationEventBuilderImpl extends CreditEvent.CreditEventBuilderImpl  implements ObligationAccelerationEvent.ObligationAccelerationEventBuilder {
	
	
		public ObligationAccelerationEventBuilderImpl() {
		}
	
		
		@Override
		public ObligationAccelerationEvent build() {
			return new ObligationAccelerationEvent.ObligationAccelerationEventImpl(this);
		}
		
		@Override
		public ObligationAccelerationEvent.ObligationAccelerationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObligationAccelerationEvent.ObligationAccelerationEventBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObligationAccelerationEvent.ObligationAccelerationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ObligationAccelerationEvent.ObligationAccelerationEventBuilder o = (ObligationAccelerationEvent.ObligationAccelerationEventBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObligationAccelerationEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
