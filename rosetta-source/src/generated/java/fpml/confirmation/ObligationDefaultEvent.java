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
import fpml.confirmation.ObligationDefaultEvent;
import fpml.confirmation.ObligationDefaultEvent.ObligationDefaultEventBuilder;
import fpml.confirmation.ObligationDefaultEvent.ObligationDefaultEventBuilderImpl;
import fpml.confirmation.ObligationDefaultEvent.ObligationDefaultEventImpl;
import fpml.confirmation.meta.ObligationDefaultEventMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="ObligationDefaultEvent", builder=ObligationDefaultEvent.ObligationDefaultEventBuilderImpl.class, version="${project.version}")
public interface ObligationDefaultEvent extends CreditEvent {

	ObligationDefaultEventMeta metaData = new ObligationDefaultEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ObligationDefaultEvent build();
	
	ObligationDefaultEvent.ObligationDefaultEventBuilder toBuilder();
	
	static ObligationDefaultEvent.ObligationDefaultEventBuilder builder() {
		return new ObligationDefaultEvent.ObligationDefaultEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObligationDefaultEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObligationDefaultEvent> getType() {
		return ObligationDefaultEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObligationDefaultEventBuilder extends ObligationDefaultEvent, CreditEvent.CreditEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		ObligationDefaultEvent.ObligationDefaultEventBuilder prune();
	}

	/*********************** Immutable Implementation of ObligationDefaultEvent  ***********************/
	class ObligationDefaultEventImpl extends CreditEvent.CreditEventImpl implements ObligationDefaultEvent {
		
		protected ObligationDefaultEventImpl(ObligationDefaultEvent.ObligationDefaultEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public ObligationDefaultEvent build() {
			return this;
		}
		
		@Override
		public ObligationDefaultEvent.ObligationDefaultEventBuilder toBuilder() {
			ObligationDefaultEvent.ObligationDefaultEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObligationDefaultEvent.ObligationDefaultEventBuilder builder) {
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
			return "ObligationDefaultEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObligationDefaultEvent  ***********************/
	class ObligationDefaultEventBuilderImpl extends CreditEvent.CreditEventBuilderImpl  implements ObligationDefaultEvent.ObligationDefaultEventBuilder {
	
	
		public ObligationDefaultEventBuilderImpl() {
		}
	
		
		@Override
		public ObligationDefaultEvent build() {
			return new ObligationDefaultEvent.ObligationDefaultEventImpl(this);
		}
		
		@Override
		public ObligationDefaultEvent.ObligationDefaultEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObligationDefaultEvent.ObligationDefaultEventBuilder prune() {
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
		public ObligationDefaultEvent.ObligationDefaultEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ObligationDefaultEvent.ObligationDefaultEventBuilder o = (ObligationDefaultEvent.ObligationDefaultEventBuilder) other;
			
			
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
			return "ObligationDefaultEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
