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
import fpml.confirmation.Lag;
import fpml.confirmation.LagOrReferenceModel;
import fpml.confirmation.LagOrReferenceModel.LagOrReferenceModelBuilder;
import fpml.confirmation.LagOrReferenceModel.LagOrReferenceModelBuilderImpl;
import fpml.confirmation.LagOrReferenceModel.LagOrReferenceModelImpl;
import fpml.confirmation.LagReference;
import fpml.confirmation.meta.LagOrReferenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Allows a Lag or a LagReference to be specified.
 * @version ${project.version}
 */
@RosettaDataType(value="LagOrReferenceModel", builder=LagOrReferenceModel.LagOrReferenceModelBuilderImpl.class, version="${project.version}")
public interface LagOrReferenceModel extends RosettaModelObject {

	LagOrReferenceModelMeta metaData = new LagOrReferenceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
	 */
	Lag getLag();
	/**
	 * Allows a lag to reference one already defined elsewhere in the trade.
	 */
	LagReference getLagReference();

	/*********************** Build Methods  ***********************/
	LagOrReferenceModel build();
	
	LagOrReferenceModel.LagOrReferenceModelBuilder toBuilder();
	
	static LagOrReferenceModel.LagOrReferenceModelBuilder builder() {
		return new LagOrReferenceModel.LagOrReferenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LagOrReferenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LagOrReferenceModel> getType() {
		return LagOrReferenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lag"), processor, Lag.class, getLag());
		processRosetta(path.newSubPath("lagReference"), processor, LagReference.class, getLagReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LagOrReferenceModelBuilder extends LagOrReferenceModel, RosettaModelObjectBuilder {
		Lag.LagBuilder getOrCreateLag();
		Lag.LagBuilder getLag();
		LagReference.LagReferenceBuilder getOrCreateLagReference();
		LagReference.LagReferenceBuilder getLagReference();
		LagOrReferenceModel.LagOrReferenceModelBuilder setLag(Lag lag);
		LagOrReferenceModel.LagOrReferenceModelBuilder setLagReference(LagReference lagReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lag"), processor, Lag.LagBuilder.class, getLag());
			processRosetta(path.newSubPath("lagReference"), processor, LagReference.LagReferenceBuilder.class, getLagReference());
		}
		

		LagOrReferenceModel.LagOrReferenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of LagOrReferenceModel  ***********************/
	class LagOrReferenceModelImpl implements LagOrReferenceModel {
		private final Lag lag;
		private final LagReference lagReference;
		
		protected LagOrReferenceModelImpl(LagOrReferenceModel.LagOrReferenceModelBuilder builder) {
			this.lag = ofNullable(builder.getLag()).map(f->f.build()).orElse(null);
			this.lagReference = ofNullable(builder.getLagReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lag")
		public Lag getLag() {
			return lag;
		}
		
		@Override
		@RosettaAttribute("lagReference")
		public LagReference getLagReference() {
			return lagReference;
		}
		
		@Override
		public LagOrReferenceModel build() {
			return this;
		}
		
		@Override
		public LagOrReferenceModel.LagOrReferenceModelBuilder toBuilder() {
			LagOrReferenceModel.LagOrReferenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LagOrReferenceModel.LagOrReferenceModelBuilder builder) {
			ofNullable(getLag()).ifPresent(builder::setLag);
			ofNullable(getLagReference()).ifPresent(builder::setLagReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LagOrReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(lagReference, _that.getLagReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (lagReference != null ? lagReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LagOrReferenceModel {" +
				"lag=" + this.lag + ", " +
				"lagReference=" + this.lagReference +
			'}';
		}
	}

	/*********************** Builder Implementation of LagOrReferenceModel  ***********************/
	class LagOrReferenceModelBuilderImpl implements LagOrReferenceModel.LagOrReferenceModelBuilder {
	
		protected Lag.LagBuilder lag;
		protected LagReference.LagReferenceBuilder lagReference;
	
		public LagOrReferenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lag")
		public Lag.LagBuilder getLag() {
			return lag;
		}
		
		@Override
		public Lag.LagBuilder getOrCreateLag() {
			Lag.LagBuilder result;
			if (lag!=null) {
				result = lag;
			}
			else {
				result = lag = Lag.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lagReference")
		public LagReference.LagReferenceBuilder getLagReference() {
			return lagReference;
		}
		
		@Override
		public LagReference.LagReferenceBuilder getOrCreateLagReference() {
			LagReference.LagReferenceBuilder result;
			if (lagReference!=null) {
				result = lagReference;
			}
			else {
				result = lagReference = LagReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lag")
		public LagOrReferenceModel.LagOrReferenceModelBuilder setLag(Lag lag) {
			this.lag = lag==null?null:lag.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lagReference")
		public LagOrReferenceModel.LagOrReferenceModelBuilder setLagReference(LagReference lagReference) {
			this.lagReference = lagReference==null?null:lagReference.toBuilder();
			return this;
		}
		
		@Override
		public LagOrReferenceModel build() {
			return new LagOrReferenceModel.LagOrReferenceModelImpl(this);
		}
		
		@Override
		public LagOrReferenceModel.LagOrReferenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LagOrReferenceModel.LagOrReferenceModelBuilder prune() {
			if (lag!=null && !lag.prune().hasData()) lag = null;
			if (lagReference!=null && !lagReference.prune().hasData()) lagReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLag()!=null && getLag().hasData()) return true;
			if (getLagReference()!=null && getLagReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LagOrReferenceModel.LagOrReferenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LagOrReferenceModel.LagOrReferenceModelBuilder o = (LagOrReferenceModel.LagOrReferenceModelBuilder) other;
			
			merger.mergeRosetta(getLag(), o.getLag(), this::setLag);
			merger.mergeRosetta(getLagReference(), o.getLagReference(), this::setLagReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LagOrReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(lagReference, _that.getLagReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (lagReference != null ? lagReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LagOrReferenceModelBuilder {" +
				"lag=" + this.lag + ", " +
				"lagReference=" + this.lagReference +
			'}';
		}
	}
}
