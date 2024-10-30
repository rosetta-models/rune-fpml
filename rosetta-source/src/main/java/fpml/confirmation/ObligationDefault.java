package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.ObligationDefault;
import fpml.confirmation.ObligationDefault.ObligationDefaultBuilder;
import fpml.confirmation.ObligationDefault.ObligationDefaultBuilderImpl;
import fpml.confirmation.ObligationDefault.ObligationDefaultImpl;
import fpml.confirmation.ObligationDefaultEvent;
import fpml.confirmation.ObligationDefaultEvent.ObligationDefaultEventBuilder;
import fpml.confirmation.ObligationDefaultEvent.ObligationDefaultEventBuilderImpl;
import fpml.confirmation.ObligationDefaultEvent.ObligationDefaultEventImpl;
import fpml.confirmation.meta.ObligationDefaultMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ObligationDefault", builder=ObligationDefault.ObligationDefaultBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ObligationDefault extends ObligationDefaultEvent {

	ObligationDefaultMeta metaData = new ObligationDefaultMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ObligationDefault build();
	
	ObligationDefault.ObligationDefaultBuilder toBuilder();
	
	static ObligationDefault.ObligationDefaultBuilder builder() {
		return new ObligationDefault.ObligationDefaultBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObligationDefault> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObligationDefault> getType() {
		return ObligationDefault.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObligationDefaultBuilder extends ObligationDefault, ObligationDefaultEvent.ObligationDefaultEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		ObligationDefault.ObligationDefaultBuilder prune();
	}

	/*********************** Immutable Implementation of ObligationDefault  ***********************/
	class ObligationDefaultImpl extends ObligationDefaultEvent.ObligationDefaultEventImpl implements ObligationDefault {
		
		protected ObligationDefaultImpl(ObligationDefault.ObligationDefaultBuilder builder) {
			super(builder);
		}
		
		@Override
		public ObligationDefault build() {
			return this;
		}
		
		@Override
		public ObligationDefault.ObligationDefaultBuilder toBuilder() {
			ObligationDefault.ObligationDefaultBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObligationDefault.ObligationDefaultBuilder builder) {
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
			return "ObligationDefault {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObligationDefault  ***********************/
	class ObligationDefaultBuilderImpl extends ObligationDefaultEvent.ObligationDefaultEventBuilderImpl  implements ObligationDefault.ObligationDefaultBuilder {
	
	
		public ObligationDefaultBuilderImpl() {
		}
	
		
		@Override
		public ObligationDefault build() {
			return new ObligationDefault.ObligationDefaultImpl(this);
		}
		
		@Override
		public ObligationDefault.ObligationDefaultBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObligationDefault.ObligationDefaultBuilder prune() {
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
		public ObligationDefault.ObligationDefaultBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ObligationDefault.ObligationDefaultBuilder o = (ObligationDefault.ObligationDefaultBuilder) other;
			
			
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
			return "ObligationDefaultBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
