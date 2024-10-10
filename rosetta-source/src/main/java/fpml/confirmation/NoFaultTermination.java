package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.FxDisruptionFallback;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilder;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilderImpl;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackImpl;
import fpml.confirmation.NoFaultTermination;
import fpml.confirmation.NoFaultTermination.NoFaultTerminationBuilder;
import fpml.confirmation.NoFaultTermination.NoFaultTerminationBuilderImpl;
import fpml.confirmation.NoFaultTermination.NoFaultTerminationImpl;
import fpml.confirmation.meta.NoFaultTerminationMeta;


/**
 * Indicates that the event may cause the transaction to terminate if all applicable provisions have been met.
 * @version ${project.version}
 */
@RosettaDataType(value="NoFaultTermination", builder=NoFaultTermination.NoFaultTerminationBuilderImpl.class, version="${project.version}")
public interface NoFaultTermination extends FxDisruptionFallback {

	NoFaultTerminationMeta metaData = new NoFaultTerminationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	NoFaultTermination build();
	
	NoFaultTermination.NoFaultTerminationBuilder toBuilder();
	
	static NoFaultTermination.NoFaultTerminationBuilder builder() {
		return new NoFaultTermination.NoFaultTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoFaultTermination> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoFaultTermination> getType() {
		return NoFaultTermination.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoFaultTerminationBuilder extends NoFaultTermination, FxDisruptionFallback.FxDisruptionFallbackBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		NoFaultTermination.NoFaultTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of NoFaultTermination  ***********************/
	class NoFaultTerminationImpl extends FxDisruptionFallback.FxDisruptionFallbackImpl implements NoFaultTermination {
		
		protected NoFaultTerminationImpl(NoFaultTermination.NoFaultTerminationBuilder builder) {
			super(builder);
		}
		
		@Override
		public NoFaultTermination build() {
			return this;
		}
		
		@Override
		public NoFaultTermination.NoFaultTerminationBuilder toBuilder() {
			NoFaultTermination.NoFaultTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoFaultTermination.NoFaultTerminationBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "NoFaultTermination {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NoFaultTermination  ***********************/
	class NoFaultTerminationBuilderImpl extends FxDisruptionFallback.FxDisruptionFallbackBuilderImpl  implements NoFaultTermination.NoFaultTerminationBuilder {
	
	
		public NoFaultTerminationBuilderImpl() {
		}
	
		
		@Override
		public NoFaultTermination build() {
			return new NoFaultTermination.NoFaultTerminationImpl(this);
		}
		
		@Override
		public NoFaultTermination.NoFaultTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoFaultTermination.NoFaultTerminationBuilder prune() {
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
		public NoFaultTermination.NoFaultTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NoFaultTermination.NoFaultTerminationBuilder o = (NoFaultTermination.NoFaultTerminationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "NoFaultTerminationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
