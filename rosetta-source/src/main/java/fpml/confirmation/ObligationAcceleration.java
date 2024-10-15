package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.ObligationAcceleration;
import fpml.confirmation.ObligationAcceleration.ObligationAccelerationBuilder;
import fpml.confirmation.ObligationAcceleration.ObligationAccelerationBuilderImpl;
import fpml.confirmation.ObligationAcceleration.ObligationAccelerationImpl;
import fpml.confirmation.ObligationAccelerationEvent;
import fpml.confirmation.ObligationAccelerationEvent.ObligationAccelerationEventBuilder;
import fpml.confirmation.ObligationAccelerationEvent.ObligationAccelerationEventBuilderImpl;
import fpml.confirmation.ObligationAccelerationEvent.ObligationAccelerationEventImpl;
import fpml.confirmation.meta.ObligationAccelerationMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="ObligationAcceleration", builder=ObligationAcceleration.ObligationAccelerationBuilderImpl.class, version="${project.version}")
public interface ObligationAcceleration extends ObligationAccelerationEvent {

	ObligationAccelerationMeta metaData = new ObligationAccelerationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ObligationAcceleration build();
	
	ObligationAcceleration.ObligationAccelerationBuilder toBuilder();
	
	static ObligationAcceleration.ObligationAccelerationBuilder builder() {
		return new ObligationAcceleration.ObligationAccelerationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObligationAcceleration> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObligationAcceleration> getType() {
		return ObligationAcceleration.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObligationAccelerationBuilder extends ObligationAcceleration, ObligationAccelerationEvent.ObligationAccelerationEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		ObligationAcceleration.ObligationAccelerationBuilder prune();
	}

	/*********************** Immutable Implementation of ObligationAcceleration  ***********************/
	class ObligationAccelerationImpl extends ObligationAccelerationEvent.ObligationAccelerationEventImpl implements ObligationAcceleration {
		
		protected ObligationAccelerationImpl(ObligationAcceleration.ObligationAccelerationBuilder builder) {
			super(builder);
		}
		
		@Override
		public ObligationAcceleration build() {
			return this;
		}
		
		@Override
		public ObligationAcceleration.ObligationAccelerationBuilder toBuilder() {
			ObligationAcceleration.ObligationAccelerationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObligationAcceleration.ObligationAccelerationBuilder builder) {
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
			return "ObligationAcceleration {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObligationAcceleration  ***********************/
	class ObligationAccelerationBuilderImpl extends ObligationAccelerationEvent.ObligationAccelerationEventBuilderImpl  implements ObligationAcceleration.ObligationAccelerationBuilder {
	
	
		public ObligationAccelerationBuilderImpl() {
		}
	
		
		@Override
		public ObligationAcceleration build() {
			return new ObligationAcceleration.ObligationAccelerationImpl(this);
		}
		
		@Override
		public ObligationAcceleration.ObligationAccelerationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObligationAcceleration.ObligationAccelerationBuilder prune() {
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
		public ObligationAcceleration.ObligationAccelerationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ObligationAcceleration.ObligationAccelerationBuilder o = (ObligationAcceleration.ObligationAccelerationBuilder) other;
			
			
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
			return "ObligationAccelerationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
