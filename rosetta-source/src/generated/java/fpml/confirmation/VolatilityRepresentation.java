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
import fpml.confirmation.Currency;
import fpml.confirmation.PricingStructure;
import fpml.confirmation.PricingStructure.PricingStructureBuilder;
import fpml.confirmation.PricingStructure.PricingStructureBuilderImpl;
import fpml.confirmation.PricingStructure.PricingStructureImpl;
import fpml.confirmation.VolatilityRepresentation;
import fpml.confirmation.VolatilityRepresentation.VolatilityRepresentationBuilder;
import fpml.confirmation.VolatilityRepresentation.VolatilityRepresentationBuilderImpl;
import fpml.confirmation.VolatilityRepresentation.VolatilityRepresentationImpl;
import fpml.confirmation.meta.VolatilityRepresentationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A representation of volatilities of an asset. This is a generic structure whose values can be supplied in a specific volatility matrix.
 * @version ${project.version}
 */
@RosettaDataType(value="VolatilityRepresentation", builder=VolatilityRepresentation.VolatilityRepresentationBuilderImpl.class, version="${project.version}")
public interface VolatilityRepresentation extends PricingStructure {

	VolatilityRepresentationMeta metaData = new VolatilityRepresentationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the asset whose volatility is modeled.
	 */
	AnyAssetReference getAsset();

	/*********************** Build Methods  ***********************/
	VolatilityRepresentation build();
	
	VolatilityRepresentation.VolatilityRepresentationBuilder toBuilder();
	
	static VolatilityRepresentation.VolatilityRepresentationBuilder builder() {
		return new VolatilityRepresentation.VolatilityRepresentationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityRepresentation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilityRepresentation> getType() {
		return VolatilityRepresentation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("asset"), processor, AnyAssetReference.class, getAsset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityRepresentationBuilder extends VolatilityRepresentation, PricingStructure.PricingStructureBuilder {
		AnyAssetReference.AnyAssetReferenceBuilder getOrCreateAsset();
		AnyAssetReference.AnyAssetReferenceBuilder getAsset();
		VolatilityRepresentation.VolatilityRepresentationBuilder setName(String name);
		VolatilityRepresentation.VolatilityRepresentationBuilder setCurrency(Currency currency);
		VolatilityRepresentation.VolatilityRepresentationBuilder setId(String id);
		VolatilityRepresentation.VolatilityRepresentationBuilder setAsset(AnyAssetReference asset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("asset"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getAsset());
		}
		

		VolatilityRepresentation.VolatilityRepresentationBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityRepresentation  ***********************/
	class VolatilityRepresentationImpl extends PricingStructure.PricingStructureImpl implements VolatilityRepresentation {
		private final AnyAssetReference asset;
		
		protected VolatilityRepresentationImpl(VolatilityRepresentation.VolatilityRepresentationBuilder builder) {
			super(builder);
			this.asset = ofNullable(builder.getAsset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("asset")
		public AnyAssetReference getAsset() {
			return asset;
		}
		
		@Override
		public VolatilityRepresentation build() {
			return this;
		}
		
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder toBuilder() {
			VolatilityRepresentation.VolatilityRepresentationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityRepresentation.VolatilityRepresentationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAsset()).ifPresent(builder::setAsset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityRepresentation _that = getType().cast(o);
		
			if (!Objects.equals(asset, _that.getAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityRepresentation {" +
				"asset=" + this.asset +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityRepresentation  ***********************/
	class VolatilityRepresentationBuilderImpl extends PricingStructure.PricingStructureBuilderImpl  implements VolatilityRepresentation.VolatilityRepresentationBuilder {
	
		protected AnyAssetReference.AnyAssetReferenceBuilder asset;
	
		public VolatilityRepresentationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("asset")
		public AnyAssetReference.AnyAssetReferenceBuilder getAsset() {
			return asset;
		}
		
		@Override
		public AnyAssetReference.AnyAssetReferenceBuilder getOrCreateAsset() {
			AnyAssetReference.AnyAssetReferenceBuilder result;
			if (asset!=null) {
				result = asset;
			}
			else {
				result = asset = AnyAssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("name")
		public VolatilityRepresentation.VolatilityRepresentationBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public VolatilityRepresentation.VolatilityRepresentationBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public VolatilityRepresentation.VolatilityRepresentationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("asset")
		public VolatilityRepresentation.VolatilityRepresentationBuilder setAsset(AnyAssetReference asset) {
			this.asset = asset==null?null:asset.toBuilder();
			return this;
		}
		
		@Override
		public VolatilityRepresentation build() {
			return new VolatilityRepresentation.VolatilityRepresentationImpl(this);
		}
		
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder prune() {
			super.prune();
			if (asset!=null && !asset.prune().hasData()) asset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAsset()!=null && getAsset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VolatilityRepresentation.VolatilityRepresentationBuilder o = (VolatilityRepresentation.VolatilityRepresentationBuilder) other;
			
			merger.mergeRosetta(getAsset(), o.getAsset(), this::setAsset);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityRepresentation _that = getType().cast(o);
		
			if (!Objects.equals(asset, _that.getAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityRepresentationBuilder {" +
				"asset=" + this.asset +
			'}' + " " + super.toString();
		}
	}
}
