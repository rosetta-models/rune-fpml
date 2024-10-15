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
import fpml.confirmation.InitialMarginCalculation;
import fpml.confirmation.InitialMarginCalculation.InitialMarginCalculationBuilder;
import fpml.confirmation.InitialMarginCalculation.InitialMarginCalculationBuilderImpl;
import fpml.confirmation.InitialMarginCalculation.InitialMarginCalculationImpl;
import fpml.confirmation.InitialMarginCalculationSequence0;
import fpml.confirmation.InitialMarginCalculationSequence1;
import fpml.confirmation.meta.InitialMarginCalculationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the initial margin calculation applicable to a single piece of collateral.
 * @version ${project.version}
 */
@RosettaDataType(value="InitialMarginCalculation", builder=InitialMarginCalculation.InitialMarginCalculationBuilderImpl.class, version="${project.version}")
public interface InitialMarginCalculation extends RosettaModelObject {

	InitialMarginCalculationMeta metaData = new InitialMarginCalculationMeta();

	/*********************** Getter Methods  ***********************/
	InitialMarginCalculationSequence0 getInitialMarginCalculationSequence0();
	InitialMarginCalculationSequence1 getInitialMarginCalculationSequence1();
	/**
	 * A reference to the collateral asset to which the margin requirement applies. This element should be produced in the case where margin requirements are specified for multiple pieces of collateral, and may be omitted otherwise.
	 */
	AssetReference getAssetReference();

	/*********************** Build Methods  ***********************/
	InitialMarginCalculation build();
	
	InitialMarginCalculation.InitialMarginCalculationBuilder toBuilder();
	
	static InitialMarginCalculation.InitialMarginCalculationBuilder builder() {
		return new InitialMarginCalculation.InitialMarginCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InitialMarginCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InitialMarginCalculation> getType() {
		return InitialMarginCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialMarginCalculationSequence0"), processor, InitialMarginCalculationSequence0.class, getInitialMarginCalculationSequence0());
		processRosetta(path.newSubPath("initialMarginCalculationSequence1"), processor, InitialMarginCalculationSequence1.class, getInitialMarginCalculationSequence1());
		processRosetta(path.newSubPath("assetReference"), processor, AssetReference.class, getAssetReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InitialMarginCalculationBuilder extends InitialMarginCalculation, RosettaModelObjectBuilder {
		InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder getOrCreateInitialMarginCalculationSequence0();
		InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder getInitialMarginCalculationSequence0();
		InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder getOrCreateInitialMarginCalculationSequence1();
		InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder getInitialMarginCalculationSequence1();
		AssetReference.AssetReferenceBuilder getOrCreateAssetReference();
		AssetReference.AssetReferenceBuilder getAssetReference();
		InitialMarginCalculation.InitialMarginCalculationBuilder setInitialMarginCalculationSequence0(InitialMarginCalculationSequence0 initialMarginCalculationSequence0);
		InitialMarginCalculation.InitialMarginCalculationBuilder setInitialMarginCalculationSequence1(InitialMarginCalculationSequence1 initialMarginCalculationSequence1);
		InitialMarginCalculation.InitialMarginCalculationBuilder setAssetReference(AssetReference assetReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialMarginCalculationSequence0"), processor, InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder.class, getInitialMarginCalculationSequence0());
			processRosetta(path.newSubPath("initialMarginCalculationSequence1"), processor, InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder.class, getInitialMarginCalculationSequence1());
			processRosetta(path.newSubPath("assetReference"), processor, AssetReference.AssetReferenceBuilder.class, getAssetReference());
		}
		

		InitialMarginCalculation.InitialMarginCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of InitialMarginCalculation  ***********************/
	class InitialMarginCalculationImpl implements InitialMarginCalculation {
		private final InitialMarginCalculationSequence0 initialMarginCalculationSequence0;
		private final InitialMarginCalculationSequence1 initialMarginCalculationSequence1;
		private final AssetReference assetReference;
		
		protected InitialMarginCalculationImpl(InitialMarginCalculation.InitialMarginCalculationBuilder builder) {
			this.initialMarginCalculationSequence0 = ofNullable(builder.getInitialMarginCalculationSequence0()).map(f->f.build()).orElse(null);
			this.initialMarginCalculationSequence1 = ofNullable(builder.getInitialMarginCalculationSequence1()).map(f->f.build()).orElse(null);
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialMarginCalculationSequence0")
		public InitialMarginCalculationSequence0 getInitialMarginCalculationSequence0() {
			return initialMarginCalculationSequence0;
		}
		
		@Override
		@RosettaAttribute("initialMarginCalculationSequence1")
		public InitialMarginCalculationSequence1 getInitialMarginCalculationSequence1() {
			return initialMarginCalculationSequence1;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		public AssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		public InitialMarginCalculation build() {
			return this;
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder toBuilder() {
			InitialMarginCalculation.InitialMarginCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InitialMarginCalculation.InitialMarginCalculationBuilder builder) {
			ofNullable(getInitialMarginCalculationSequence0()).ifPresent(builder::setInitialMarginCalculationSequence0);
			ofNullable(getInitialMarginCalculationSequence1()).ifPresent(builder::setInitialMarginCalculationSequence1);
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMarginCalculation _that = getType().cast(o);
		
			if (!Objects.equals(initialMarginCalculationSequence0, _that.getInitialMarginCalculationSequence0())) return false;
			if (!Objects.equals(initialMarginCalculationSequence1, _that.getInitialMarginCalculationSequence1())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialMarginCalculationSequence0 != null ? initialMarginCalculationSequence0.hashCode() : 0);
			_result = 31 * _result + (initialMarginCalculationSequence1 != null ? initialMarginCalculationSequence1.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginCalculation {" +
				"initialMarginCalculationSequence0=" + this.initialMarginCalculationSequence0 + ", " +
				"initialMarginCalculationSequence1=" + this.initialMarginCalculationSequence1 + ", " +
				"assetReference=" + this.assetReference +
			'}';
		}
	}

	/*********************** Builder Implementation of InitialMarginCalculation  ***********************/
	class InitialMarginCalculationBuilderImpl implements InitialMarginCalculation.InitialMarginCalculationBuilder {
	
		protected InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder initialMarginCalculationSequence0;
		protected InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder initialMarginCalculationSequence1;
		protected AssetReference.AssetReferenceBuilder assetReference;
	
		public InitialMarginCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialMarginCalculationSequence0")
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder getInitialMarginCalculationSequence0() {
			return initialMarginCalculationSequence0;
		}
		
		@Override
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder getOrCreateInitialMarginCalculationSequence0() {
			InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder result;
			if (initialMarginCalculationSequence0!=null) {
				result = initialMarginCalculationSequence0;
			}
			else {
				result = initialMarginCalculationSequence0 = InitialMarginCalculationSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialMarginCalculationSequence1")
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder getInitialMarginCalculationSequence1() {
			return initialMarginCalculationSequence1;
		}
		
		@Override
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder getOrCreateInitialMarginCalculationSequence1() {
			InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder result;
			if (initialMarginCalculationSequence1!=null) {
				result = initialMarginCalculationSequence1;
			}
			else {
				result = initialMarginCalculationSequence1 = InitialMarginCalculationSequence1.builder();
			}
			
			return result;
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
		@RosettaAttribute("initialMarginCalculationSequence0")
		public InitialMarginCalculation.InitialMarginCalculationBuilder setInitialMarginCalculationSequence0(InitialMarginCalculationSequence0 initialMarginCalculationSequence0) {
			this.initialMarginCalculationSequence0 = initialMarginCalculationSequence0==null?null:initialMarginCalculationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialMarginCalculationSequence1")
		public InitialMarginCalculation.InitialMarginCalculationBuilder setInitialMarginCalculationSequence1(InitialMarginCalculationSequence1 initialMarginCalculationSequence1) {
			this.initialMarginCalculationSequence1 = initialMarginCalculationSequence1==null?null:initialMarginCalculationSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("assetReference")
		public InitialMarginCalculation.InitialMarginCalculationBuilder setAssetReference(AssetReference assetReference) {
			this.assetReference = assetReference==null?null:assetReference.toBuilder();
			return this;
		}
		
		@Override
		public InitialMarginCalculation build() {
			return new InitialMarginCalculation.InitialMarginCalculationImpl(this);
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder prune() {
			if (initialMarginCalculationSequence0!=null && !initialMarginCalculationSequence0.prune().hasData()) initialMarginCalculationSequence0 = null;
			if (initialMarginCalculationSequence1!=null && !initialMarginCalculationSequence1.prune().hasData()) initialMarginCalculationSequence1 = null;
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialMarginCalculationSequence0()!=null && getInitialMarginCalculationSequence0().hasData()) return true;
			if (getInitialMarginCalculationSequence1()!=null && getInitialMarginCalculationSequence1().hasData()) return true;
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InitialMarginCalculation.InitialMarginCalculationBuilder o = (InitialMarginCalculation.InitialMarginCalculationBuilder) other;
			
			merger.mergeRosetta(getInitialMarginCalculationSequence0(), o.getInitialMarginCalculationSequence0(), this::setInitialMarginCalculationSequence0);
			merger.mergeRosetta(getInitialMarginCalculationSequence1(), o.getInitialMarginCalculationSequence1(), this::setInitialMarginCalculationSequence1);
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMarginCalculation _that = getType().cast(o);
		
			if (!Objects.equals(initialMarginCalculationSequence0, _that.getInitialMarginCalculationSequence0())) return false;
			if (!Objects.equals(initialMarginCalculationSequence1, _that.getInitialMarginCalculationSequence1())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialMarginCalculationSequence0 != null ? initialMarginCalculationSequence0.hashCode() : 0);
			_result = 31 * _result + (initialMarginCalculationSequence1 != null ? initialMarginCalculationSequence1.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginCalculationBuilder {" +
				"initialMarginCalculationSequence0=" + this.initialMarginCalculationSequence0 + ", " +
				"initialMarginCalculationSequence1=" + this.initialMarginCalculationSequence1 + ", " +
				"assetReference=" + this.assetReference +
			'}';
		}
	}
}
