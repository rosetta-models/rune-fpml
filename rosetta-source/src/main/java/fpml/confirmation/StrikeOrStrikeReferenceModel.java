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
import fpml.confirmation.FxStrike;
import fpml.confirmation.FxStrikeReference;
import fpml.confirmation.StrikeOrStrikeReferenceModel;
import fpml.confirmation.StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder;
import fpml.confirmation.StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilderImpl;
import fpml.confirmation.StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelImpl;
import fpml.confirmation.meta.StrikeOrStrikeReferenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="StrikeOrStrikeReferenceModel", builder=StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilderImpl.class, version="${project.version}")
public interface StrikeOrStrikeReferenceModel extends RosettaModelObject {

	StrikeOrStrikeReferenceModelMeta metaData = new StrikeOrStrikeReferenceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Strike price of the Target.
	 */
	FxStrike getStrike();
	/**
	 * Reference to an existing strike structure within the FX product.
	 */
	FxStrikeReference getStrikeReference();

	/*********************** Build Methods  ***********************/
	StrikeOrStrikeReferenceModel build();
	
	StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder toBuilder();
	
	static StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder builder() {
		return new StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StrikeOrStrikeReferenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StrikeOrStrikeReferenceModel> getType() {
		return StrikeOrStrikeReferenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("strike"), processor, FxStrike.class, getStrike());
		processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.class, getStrikeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrikeOrStrikeReferenceModelBuilder extends StrikeOrStrikeReferenceModel, RosettaModelObjectBuilder {
		FxStrike.FxStrikeBuilder getOrCreateStrike();
		FxStrike.FxStrikeBuilder getStrike();
		FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference();
		FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference();
		StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder setStrike(FxStrike strike);
		StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder setStrikeReference(FxStrikeReference strikeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("strike"), processor, FxStrike.FxStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.FxStrikeReferenceBuilder.class, getStrikeReference());
		}
		

		StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of StrikeOrStrikeReferenceModel  ***********************/
	class StrikeOrStrikeReferenceModelImpl implements StrikeOrStrikeReferenceModel {
		private final FxStrike strike;
		private final FxStrikeReference strikeReference;
		
		protected StrikeOrStrikeReferenceModelImpl(StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder builder) {
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strike")
		public FxStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		public FxStrikeReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public StrikeOrStrikeReferenceModel build() {
			return this;
		}
		
		@Override
		public StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder toBuilder() {
			StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder builder) {
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StrikeOrStrikeReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeOrStrikeReferenceModel {" +
				"strike=" + this.strike + ", " +
				"strikeReference=" + this.strikeReference +
			'}';
		}
	}

	/*********************** Builder Implementation of StrikeOrStrikeReferenceModel  ***********************/
	class StrikeOrStrikeReferenceModelBuilderImpl implements StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder {
	
		protected FxStrike.FxStrikeBuilder strike;
		protected FxStrikeReference.FxStrikeReferenceBuilder strikeReference;
	
		public StrikeOrStrikeReferenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strike")
		public FxStrike.FxStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxStrike.FxStrikeBuilder getOrCreateStrike() {
			FxStrike.FxStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		public FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference() {
			FxStrikeReference.FxStrikeReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FxStrikeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		public StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder setStrike(FxStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikeReference")
		public StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder setStrikeReference(FxStrikeReference strikeReference) {
			this.strikeReference = strikeReference==null?null:strikeReference.toBuilder();
			return this;
		}
		
		@Override
		public StrikeOrStrikeReferenceModel build() {
			return new StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelImpl(this);
		}
		
		@Override
		public StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder prune() {
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder o = (StrikeOrStrikeReferenceModel.StrikeOrStrikeReferenceModelBuilder) other;
			
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StrikeOrStrikeReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeOrStrikeReferenceModelBuilder {" +
				"strike=" + this.strike + ", " +
				"strikeReference=" + this.strikeReference +
			'}';
		}
	}
}
