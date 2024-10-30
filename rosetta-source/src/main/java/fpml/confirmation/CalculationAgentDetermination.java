package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CalculationAgentDetermination;
import fpml.confirmation.CalculationAgentDetermination.CalculationAgentDeterminationBuilder;
import fpml.confirmation.CalculationAgentDetermination.CalculationAgentDeterminationBuilderImpl;
import fpml.confirmation.CalculationAgentDetermination.CalculationAgentDeterminationImpl;
import fpml.confirmation.FxDisruptionFallback;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilder;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilderImpl;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackImpl;
import fpml.confirmation.meta.CalculationAgentDeterminationMeta;


/**
 * Indicates that the Calculation Agent shall determine the Spot Rate (or a method for determining the Spot Rate) taking into consideration all available information that it reasonably and in good faith deems relevent.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CalculationAgentDetermination", builder=CalculationAgentDetermination.CalculationAgentDeterminationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CalculationAgentDetermination extends FxDisruptionFallback {

	CalculationAgentDeterminationMeta metaData = new CalculationAgentDeterminationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CalculationAgentDetermination build();
	
	CalculationAgentDetermination.CalculationAgentDeterminationBuilder toBuilder();
	
	static CalculationAgentDetermination.CalculationAgentDeterminationBuilder builder() {
		return new CalculationAgentDetermination.CalculationAgentDeterminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationAgentDetermination> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationAgentDetermination> getType() {
		return CalculationAgentDetermination.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationAgentDeterminationBuilder extends CalculationAgentDetermination, FxDisruptionFallback.FxDisruptionFallbackBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		CalculationAgentDetermination.CalculationAgentDeterminationBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationAgentDetermination  ***********************/
	class CalculationAgentDeterminationImpl extends FxDisruptionFallback.FxDisruptionFallbackImpl implements CalculationAgentDetermination {
		
		protected CalculationAgentDeterminationImpl(CalculationAgentDetermination.CalculationAgentDeterminationBuilder builder) {
			super(builder);
		}
		
		@Override
		public CalculationAgentDetermination build() {
			return this;
		}
		
		@Override
		public CalculationAgentDetermination.CalculationAgentDeterminationBuilder toBuilder() {
			CalculationAgentDetermination.CalculationAgentDeterminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAgentDetermination.CalculationAgentDeterminationBuilder builder) {
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
			return "CalculationAgentDetermination {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationAgentDetermination  ***********************/
	class CalculationAgentDeterminationBuilderImpl extends FxDisruptionFallback.FxDisruptionFallbackBuilderImpl  implements CalculationAgentDetermination.CalculationAgentDeterminationBuilder {
	
	
		public CalculationAgentDeterminationBuilderImpl() {
		}
	
		
		@Override
		public CalculationAgentDetermination build() {
			return new CalculationAgentDetermination.CalculationAgentDeterminationImpl(this);
		}
		
		@Override
		public CalculationAgentDetermination.CalculationAgentDeterminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgentDetermination.CalculationAgentDeterminationBuilder prune() {
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
		public CalculationAgentDetermination.CalculationAgentDeterminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationAgentDetermination.CalculationAgentDeterminationBuilder o = (CalculationAgentDetermination.CalculationAgentDeterminationBuilder) other;
			
			
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
			return "CalculationAgentDeterminationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
