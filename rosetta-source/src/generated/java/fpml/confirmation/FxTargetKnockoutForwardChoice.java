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
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.FxTargetKnockoutForwardChoice;
import fpml.confirmation.FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder;
import fpml.confirmation.FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilderImpl;
import fpml.confirmation.FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceImpl;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import fpml.confirmation.meta.FxTargetKnockoutForwardChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetKnockoutForwardChoice", builder=FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilderImpl.class, version="${project.version}")
public interface FxTargetKnockoutForwardChoice extends RosettaModelObject {

	FxTargetKnockoutForwardChoiceMeta metaData = new FxTargetKnockoutForwardChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * It defines a region in which a digital payment occurs.
	 */
	FxTargetConstantPayoffRegion getConstantPayoffRegion();
	/**
	 * A region in which linear payoff applies i.e. the payoff bears a linear relationship to the fixing value (increases/decreases linearly with the fixing).
	 */
	FxTargetLinearPayoffRegion getLinearPayoffRegion();

	/*********************** Build Methods  ***********************/
	FxTargetKnockoutForwardChoice build();
	
	FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder toBuilder();
	
	static FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder builder() {
		return new FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetKnockoutForwardChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetKnockoutForwardChoice> getType() {
		return FxTargetKnockoutForwardChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("constantPayoffRegion"), processor, FxTargetConstantPayoffRegion.class, getConstantPayoffRegion());
		processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxTargetLinearPayoffRegion.class, getLinearPayoffRegion());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetKnockoutForwardChoiceBuilder extends FxTargetKnockoutForwardChoice, RosettaModelObjectBuilder {
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getOrCreateConstantPayoffRegion();
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getConstantPayoffRegion();
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion();
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getLinearPayoffRegion();
		FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder setConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion);
		FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder setLinearPayoffRegion(FxTargetLinearPayoffRegion linearPayoffRegion);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("constantPayoffRegion"), processor, FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder.class, getConstantPayoffRegion());
			processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder.class, getLinearPayoffRegion());
		}
		

		FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetKnockoutForwardChoice  ***********************/
	class FxTargetKnockoutForwardChoiceImpl implements FxTargetKnockoutForwardChoice {
		private final FxTargetConstantPayoffRegion constantPayoffRegion;
		private final FxTargetLinearPayoffRegion linearPayoffRegion;
		
		protected FxTargetKnockoutForwardChoiceImpl(FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder builder) {
			this.constantPayoffRegion = ofNullable(builder.getConstantPayoffRegion()).map(f->f.build()).orElse(null);
			this.linearPayoffRegion = ofNullable(builder.getLinearPayoffRegion()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("constantPayoffRegion")
		public FxTargetConstantPayoffRegion getConstantPayoffRegion() {
			return constantPayoffRegion;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetLinearPayoffRegion getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		public FxTargetKnockoutForwardChoice build() {
			return this;
		}
		
		@Override
		public FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder toBuilder() {
			FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder builder) {
			ofNullable(getConstantPayoffRegion()).ifPresent(builder::setConstantPayoffRegion);
			ofNullable(getLinearPayoffRegion()).ifPresent(builder::setLinearPayoffRegion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetKnockoutForwardChoice _that = getType().cast(o);
		
			if (!Objects.equals(constantPayoffRegion, _that.getConstantPayoffRegion())) return false;
			if (!Objects.equals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (constantPayoffRegion != null ? constantPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetKnockoutForwardChoice {" +
				"constantPayoffRegion=" + this.constantPayoffRegion + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetKnockoutForwardChoice  ***********************/
	class FxTargetKnockoutForwardChoiceBuilderImpl implements FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder {
	
		protected FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder constantPayoffRegion;
		protected FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder linearPayoffRegion;
	
		public FxTargetKnockoutForwardChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("constantPayoffRegion")
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getConstantPayoffRegion() {
			return constantPayoffRegion;
		}
		
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getOrCreateConstantPayoffRegion() {
			FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder result;
			if (constantPayoffRegion!=null) {
				result = constantPayoffRegion;
			}
			else {
				result = constantPayoffRegion = FxTargetConstantPayoffRegion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion() {
			FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder result;
			if (linearPayoffRegion!=null) {
				result = linearPayoffRegion;
			}
			else {
				result = linearPayoffRegion = FxTargetLinearPayoffRegion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("constantPayoffRegion")
		public FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder setConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion) {
			this.constantPayoffRegion = constantPayoffRegion==null?null:constantPayoffRegion.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder setLinearPayoffRegion(FxTargetLinearPayoffRegion linearPayoffRegion) {
			this.linearPayoffRegion = linearPayoffRegion==null?null:linearPayoffRegion.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetKnockoutForwardChoice build() {
			return new FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceImpl(this);
		}
		
		@Override
		public FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder prune() {
			if (constantPayoffRegion!=null && !constantPayoffRegion.prune().hasData()) constantPayoffRegion = null;
			if (linearPayoffRegion!=null && !linearPayoffRegion.prune().hasData()) linearPayoffRegion = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConstantPayoffRegion()!=null && getConstantPayoffRegion().hasData()) return true;
			if (getLinearPayoffRegion()!=null && getLinearPayoffRegion().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder o = (FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder) other;
			
			merger.mergeRosetta(getConstantPayoffRegion(), o.getConstantPayoffRegion(), this::setConstantPayoffRegion);
			merger.mergeRosetta(getLinearPayoffRegion(), o.getLinearPayoffRegion(), this::setLinearPayoffRegion);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetKnockoutForwardChoice _that = getType().cast(o);
		
			if (!Objects.equals(constantPayoffRegion, _that.getConstantPayoffRegion())) return false;
			if (!Objects.equals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (constantPayoffRegion != null ? constantPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetKnockoutForwardChoiceBuilder {" +
				"constantPayoffRegion=" + this.constantPayoffRegion + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion +
			'}';
		}
	}
}
