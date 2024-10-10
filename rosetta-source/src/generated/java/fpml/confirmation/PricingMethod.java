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
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.PricingMethod;
import fpml.confirmation.PricingMethod.PricingMethodBuilder;
import fpml.confirmation.PricingMethod.PricingMethodBuilderImpl;
import fpml.confirmation.PricingMethod.PricingMethodImpl;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.meta.PricingMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * For an asset (e.g. a reference/benchmark asset), the pricing structure used to price it. Used, for example, to specify that the rateIndex &quot;USD-LIBOR-Telerate&quot; with term = 6M is priced using the &quot;USD-LIBOR-Close&quot; curve.
 * @version ${project.version}
 */
@RosettaDataType(value="PricingMethod", builder=PricingMethod.PricingMethodBuilderImpl.class, version="${project.version}")
public interface PricingMethod extends RosettaModelObject {

	PricingMethodMeta metaData = new PricingMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The asset whose price is required.
	 */
	AnyAssetReference getAssetReference();
	/**
	 * A reference to the pricing input used to value the asset.
	 */
	PricingStructureReference getPricingInputReference();

	/*********************** Build Methods  ***********************/
	PricingMethod build();
	
	PricingMethod.PricingMethodBuilder toBuilder();
	
	static PricingMethod.PricingMethodBuilder builder() {
		return new PricingMethod.PricingMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingMethod> getType() {
		return PricingMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("assetReference"), processor, AnyAssetReference.class, getAssetReference());
		processRosetta(path.newSubPath("pricingInputReference"), processor, PricingStructureReference.class, getPricingInputReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingMethodBuilder extends PricingMethod, RosettaModelObjectBuilder {
		AnyAssetReference.AnyAssetReferenceBuilder getOrCreateAssetReference();
		AnyAssetReference.AnyAssetReferenceBuilder getAssetReference();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingInputReference();
		PricingStructureReference.PricingStructureReferenceBuilder getPricingInputReference();
		PricingMethod.PricingMethodBuilder setAssetReference(AnyAssetReference assetReference);
		PricingMethod.PricingMethodBuilder setPricingInputReference(PricingStructureReference pricingInputReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("assetReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getAssetReference());
			processRosetta(path.newSubPath("pricingInputReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getPricingInputReference());
		}
		

		PricingMethod.PricingMethodBuilder prune();
	}

	/*********************** Immutable Implementation of PricingMethod  ***********************/
	class PricingMethodImpl implements PricingMethod {
		private final AnyAssetReference assetReference;
		private final PricingStructureReference pricingInputReference;
		
		protected PricingMethodImpl(PricingMethod.PricingMethodBuilder builder) {
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
			this.pricingInputReference = ofNullable(builder.getPricingInputReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("assetReference")
		public AnyAssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		@RosettaAttribute("pricingInputReference")
		public PricingStructureReference getPricingInputReference() {
			return pricingInputReference;
		}
		
		@Override
		public PricingMethod build() {
			return this;
		}
		
		@Override
		public PricingMethod.PricingMethodBuilder toBuilder() {
			PricingMethod.PricingMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingMethod.PricingMethodBuilder builder) {
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
			ofNullable(getPricingInputReference()).ifPresent(builder::setPricingInputReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingMethod _that = getType().cast(o);
		
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(pricingInputReference, _that.getPricingInputReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (pricingInputReference != null ? pricingInputReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingMethod {" +
				"assetReference=" + this.assetReference + ", " +
				"pricingInputReference=" + this.pricingInputReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingMethod  ***********************/
	class PricingMethodBuilderImpl implements PricingMethod.PricingMethodBuilder {
	
		protected AnyAssetReference.AnyAssetReferenceBuilder assetReference;
		protected PricingStructureReference.PricingStructureReferenceBuilder pricingInputReference;
	
		public PricingMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("assetReference")
		public AnyAssetReference.AnyAssetReferenceBuilder getAssetReference() {
			return assetReference;
		}
		
		@Override
		public AnyAssetReference.AnyAssetReferenceBuilder getOrCreateAssetReference() {
			AnyAssetReference.AnyAssetReferenceBuilder result;
			if (assetReference!=null) {
				result = assetReference;
			}
			else {
				result = assetReference = AnyAssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingInputReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getPricingInputReference() {
			return pricingInputReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingInputReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (pricingInputReference!=null) {
				result = pricingInputReference;
			}
			else {
				result = pricingInputReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		public PricingMethod.PricingMethodBuilder setAssetReference(AnyAssetReference assetReference) {
			this.assetReference = assetReference==null?null:assetReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricingInputReference")
		public PricingMethod.PricingMethodBuilder setPricingInputReference(PricingStructureReference pricingInputReference) {
			this.pricingInputReference = pricingInputReference==null?null:pricingInputReference.toBuilder();
			return this;
		}
		
		@Override
		public PricingMethod build() {
			return new PricingMethod.PricingMethodImpl(this);
		}
		
		@Override
		public PricingMethod.PricingMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingMethod.PricingMethodBuilder prune() {
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			if (pricingInputReference!=null && !pricingInputReference.prune().hasData()) pricingInputReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			if (getPricingInputReference()!=null && getPricingInputReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingMethod.PricingMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingMethod.PricingMethodBuilder o = (PricingMethod.PricingMethodBuilder) other;
			
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			merger.mergeRosetta(getPricingInputReference(), o.getPricingInputReference(), this::setPricingInputReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingMethod _that = getType().cast(o);
		
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(pricingInputReference, _that.getPricingInputReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (pricingInputReference != null ? pricingInputReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingMethodBuilder {" +
				"assetReference=" + this.assetReference + ", " +
				"pricingInputReference=" + this.pricingInputReference +
			'}';
		}
	}
}
