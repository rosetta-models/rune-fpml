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
import fpml.confirmation.AssetReference;
import fpml.confirmation.ForwardRateCurve;
import fpml.confirmation.ForwardRateCurve.ForwardRateCurveBuilder;
import fpml.confirmation.ForwardRateCurve.ForwardRateCurveBuilderImpl;
import fpml.confirmation.ForwardRateCurve.ForwardRateCurveImpl;
import fpml.confirmation.TermCurve;
import fpml.confirmation.meta.ForwardRateCurveMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A curve used to model a set of forward interest rates. Used for forecasting interest rates as part of a pricing calculation.
 * @version ${project.version}
 */
@RosettaDataType(value="ForwardRateCurve", builder=ForwardRateCurve.ForwardRateCurveBuilderImpl.class, version="${project.version}")
public interface ForwardRateCurve extends RosettaModelObject {

	ForwardRateCurveMeta metaData = new ForwardRateCurveMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the rate index whose forwards are modeled.
	 */
	AssetReference getAssetReference();
	/**
	 * The curve of forward values.
	 */
	TermCurve getRateCurve();

	/*********************** Build Methods  ***********************/
	ForwardRateCurve build();
	
	ForwardRateCurve.ForwardRateCurveBuilder toBuilder();
	
	static ForwardRateCurve.ForwardRateCurveBuilder builder() {
		return new ForwardRateCurve.ForwardRateCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ForwardRateCurve> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ForwardRateCurve> getType() {
		return ForwardRateCurve.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("assetReference"), processor, AssetReference.class, getAssetReference());
		processRosetta(path.newSubPath("rateCurve"), processor, TermCurve.class, getRateCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ForwardRateCurveBuilder extends ForwardRateCurve, RosettaModelObjectBuilder {
		AssetReference.AssetReferenceBuilder getOrCreateAssetReference();
		AssetReference.AssetReferenceBuilder getAssetReference();
		TermCurve.TermCurveBuilder getOrCreateRateCurve();
		TermCurve.TermCurveBuilder getRateCurve();
		ForwardRateCurve.ForwardRateCurveBuilder setAssetReference(AssetReference assetReference);
		ForwardRateCurve.ForwardRateCurveBuilder setRateCurve(TermCurve rateCurve);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("assetReference"), processor, AssetReference.AssetReferenceBuilder.class, getAssetReference());
			processRosetta(path.newSubPath("rateCurve"), processor, TermCurve.TermCurveBuilder.class, getRateCurve());
		}
		

		ForwardRateCurve.ForwardRateCurveBuilder prune();
	}

	/*********************** Immutable Implementation of ForwardRateCurve  ***********************/
	class ForwardRateCurveImpl implements ForwardRateCurve {
		private final AssetReference assetReference;
		private final TermCurve rateCurve;
		
		protected ForwardRateCurveImpl(ForwardRateCurve.ForwardRateCurveBuilder builder) {
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
			this.rateCurve = ofNullable(builder.getRateCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("assetReference")
		public AssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		@RosettaAttribute("rateCurve")
		public TermCurve getRateCurve() {
			return rateCurve;
		}
		
		@Override
		public ForwardRateCurve build() {
			return this;
		}
		
		@Override
		public ForwardRateCurve.ForwardRateCurveBuilder toBuilder() {
			ForwardRateCurve.ForwardRateCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ForwardRateCurve.ForwardRateCurveBuilder builder) {
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
			ofNullable(getRateCurve()).ifPresent(builder::setRateCurve);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ForwardRateCurve _that = getType().cast(o);
		
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(rateCurve, _that.getRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (rateCurve != null ? rateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ForwardRateCurve {" +
				"assetReference=" + this.assetReference + ", " +
				"rateCurve=" + this.rateCurve +
			'}';
		}
	}

	/*********************** Builder Implementation of ForwardRateCurve  ***********************/
	class ForwardRateCurveBuilderImpl implements ForwardRateCurve.ForwardRateCurveBuilder {
	
		protected AssetReference.AssetReferenceBuilder assetReference;
		protected TermCurve.TermCurveBuilder rateCurve;
	
		public ForwardRateCurveBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("assetReference")
		public AssetReference.AssetReferenceBuilder getAssetReference() {
			return assetReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateAssetReference() {
			AssetReference.AssetReferenceBuilder result;
			if (assetReference!=null) {
				result = assetReference;
			}
			else {
				result = assetReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateCurve")
		public TermCurve.TermCurveBuilder getRateCurve() {
			return rateCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateRateCurve() {
			TermCurve.TermCurveBuilder result;
			if (rateCurve!=null) {
				result = rateCurve;
			}
			else {
				result = rateCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		public ForwardRateCurve.ForwardRateCurveBuilder setAssetReference(AssetReference assetReference) {
			this.assetReference = assetReference==null?null:assetReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateCurve")
		public ForwardRateCurve.ForwardRateCurveBuilder setRateCurve(TermCurve rateCurve) {
			this.rateCurve = rateCurve==null?null:rateCurve.toBuilder();
			return this;
		}
		
		@Override
		public ForwardRateCurve build() {
			return new ForwardRateCurve.ForwardRateCurveImpl(this);
		}
		
		@Override
		public ForwardRateCurve.ForwardRateCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ForwardRateCurve.ForwardRateCurveBuilder prune() {
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			if (rateCurve!=null && !rateCurve.prune().hasData()) rateCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			if (getRateCurve()!=null && getRateCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ForwardRateCurve.ForwardRateCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ForwardRateCurve.ForwardRateCurveBuilder o = (ForwardRateCurve.ForwardRateCurveBuilder) other;
			
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			merger.mergeRosetta(getRateCurve(), o.getRateCurve(), this::setRateCurve);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ForwardRateCurve _that = getType().cast(o);
		
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(rateCurve, _that.getRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (rateCurve != null ? rateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ForwardRateCurveBuilder {" +
				"assetReference=" + this.assetReference + ", " +
				"rateCurve=" + this.rateCurve +
			'}';
		}
	}
}
