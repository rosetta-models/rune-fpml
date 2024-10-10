package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CollateralValueAllocation;
import fpml.confirmation.ProposedCollateralAllocationChoice;
import fpml.confirmation.ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder;
import fpml.confirmation.ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilderImpl;
import fpml.confirmation.ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceImpl;
import fpml.confirmation.meta.ProposedCollateralAllocationChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ProposedCollateralAllocationChoice", builder=ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilderImpl.class, version="${project.version}")
public interface ProposedCollateralAllocationChoice extends RosettaModelObject {

	ProposedCollateralAllocationChoiceMeta metaData = new ProposedCollateralAllocationChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Collateral allocation by value.
	 */
	CollateralValueAllocation getCollateralValueAllocation();

	/*********************** Build Methods  ***********************/
	ProposedCollateralAllocationChoice build();
	
	ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder toBuilder();
	
	static ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder builder() {
		return new ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProposedCollateralAllocationChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProposedCollateralAllocationChoice> getType() {
		return ProposedCollateralAllocationChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralValueAllocation"), processor, CollateralValueAllocation.class, getCollateralValueAllocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProposedCollateralAllocationChoiceBuilder extends ProposedCollateralAllocationChoice, RosettaModelObjectBuilder {
		CollateralValueAllocation.CollateralValueAllocationBuilder getOrCreateCollateralValueAllocation();
		CollateralValueAllocation.CollateralValueAllocationBuilder getCollateralValueAllocation();
		ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder setCollateralValueAllocation(CollateralValueAllocation collateralValueAllocation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralValueAllocation"), processor, CollateralValueAllocation.CollateralValueAllocationBuilder.class, getCollateralValueAllocation());
		}
		

		ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of ProposedCollateralAllocationChoice  ***********************/
	class ProposedCollateralAllocationChoiceImpl implements ProposedCollateralAllocationChoice {
		private final CollateralValueAllocation collateralValueAllocation;
		
		protected ProposedCollateralAllocationChoiceImpl(ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder builder) {
			this.collateralValueAllocation = ofNullable(builder.getCollateralValueAllocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("collateralValueAllocation")
		public CollateralValueAllocation getCollateralValueAllocation() {
			return collateralValueAllocation;
		}
		
		@Override
		public ProposedCollateralAllocationChoice build() {
			return this;
		}
		
		@Override
		public ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder toBuilder() {
			ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder builder) {
			ofNullable(getCollateralValueAllocation()).ifPresent(builder::setCollateralValueAllocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProposedCollateralAllocationChoice _that = getType().cast(o);
		
			if (!Objects.equals(collateralValueAllocation, _that.getCollateralValueAllocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralValueAllocation != null ? collateralValueAllocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProposedCollateralAllocationChoice {" +
				"collateralValueAllocation=" + this.collateralValueAllocation +
			'}';
		}
	}

	/*********************** Builder Implementation of ProposedCollateralAllocationChoice  ***********************/
	class ProposedCollateralAllocationChoiceBuilderImpl implements ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder {
	
		protected CollateralValueAllocation.CollateralValueAllocationBuilder collateralValueAllocation;
	
		public ProposedCollateralAllocationChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("collateralValueAllocation")
		public CollateralValueAllocation.CollateralValueAllocationBuilder getCollateralValueAllocation() {
			return collateralValueAllocation;
		}
		
		@Override
		public CollateralValueAllocation.CollateralValueAllocationBuilder getOrCreateCollateralValueAllocation() {
			CollateralValueAllocation.CollateralValueAllocationBuilder result;
			if (collateralValueAllocation!=null) {
				result = collateralValueAllocation;
			}
			else {
				result = collateralValueAllocation = CollateralValueAllocation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralValueAllocation")
		public ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder setCollateralValueAllocation(CollateralValueAllocation collateralValueAllocation) {
			this.collateralValueAllocation = collateralValueAllocation==null?null:collateralValueAllocation.toBuilder();
			return this;
		}
		
		@Override
		public ProposedCollateralAllocationChoice build() {
			return new ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceImpl(this);
		}
		
		@Override
		public ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder prune() {
			if (collateralValueAllocation!=null && !collateralValueAllocation.prune().hasData()) collateralValueAllocation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralValueAllocation()!=null && getCollateralValueAllocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder o = (ProposedCollateralAllocationChoice.ProposedCollateralAllocationChoiceBuilder) other;
			
			merger.mergeRosetta(getCollateralValueAllocation(), o.getCollateralValueAllocation(), this::setCollateralValueAllocation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProposedCollateralAllocationChoice _that = getType().cast(o);
		
			if (!Objects.equals(collateralValueAllocation, _that.getCollateralValueAllocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralValueAllocation != null ? collateralValueAllocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProposedCollateralAllocationChoiceBuilder {" +
				"collateralValueAllocation=" + this.collateralValueAllocation +
			'}';
		}
	}
}
