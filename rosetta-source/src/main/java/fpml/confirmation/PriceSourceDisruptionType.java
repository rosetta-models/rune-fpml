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
import fpml.confirmation.FallbackReferencePriceType;
import fpml.confirmation.PriceSourceDisruptionType;
import fpml.confirmation.PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder;
import fpml.confirmation.PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilderImpl;
import fpml.confirmation.PriceSourceDisruptionType.PriceSourceDisruptionTypeImpl;
import fpml.confirmation.meta.PriceSourceDisruptionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the parameters used to get a price quote to replace the settlement rate option that is disrupted.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PriceSourceDisruptionType", builder=PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PriceSourceDisruptionType extends RosettaModelObject {

	PriceSourceDisruptionTypeMeta metaData = new PriceSourceDisruptionTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The method, prioritzed by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
	 */
	FallbackReferencePriceType getFallbackReferencePrice();

	/*********************** Build Methods  ***********************/
	PriceSourceDisruptionType build();
	
	PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder toBuilder();
	
	static PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder builder() {
		return new PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceSourceDisruptionType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PriceSourceDisruptionType> getType() {
		return PriceSourceDisruptionType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fallbackReferencePrice"), processor, FallbackReferencePriceType.class, getFallbackReferencePrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceSourceDisruptionTypeBuilder extends PriceSourceDisruptionType, RosettaModelObjectBuilder {
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder getOrCreateFallbackReferencePrice();
		FallbackReferencePriceType.FallbackReferencePriceTypeBuilder getFallbackReferencePrice();
		PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder setFallbackReferencePrice(FallbackReferencePriceType fallbackReferencePrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fallbackReferencePrice"), processor, FallbackReferencePriceType.FallbackReferencePriceTypeBuilder.class, getFallbackReferencePrice());
		}
		

		PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PriceSourceDisruptionType  ***********************/
	class PriceSourceDisruptionTypeImpl implements PriceSourceDisruptionType {
		private final FallbackReferencePriceType fallbackReferencePrice;
		
		protected PriceSourceDisruptionTypeImpl(PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder builder) {
			this.fallbackReferencePrice = ofNullable(builder.getFallbackReferencePrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		public FallbackReferencePriceType getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public PriceSourceDisruptionType build() {
			return this;
		}
		
		@Override
		public PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder toBuilder() {
			PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder builder) {
			ofNullable(getFallbackReferencePrice()).ifPresent(builder::setFallbackReferencePrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceSourceDisruptionType _that = getType().cast(o);
		
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceSourceDisruptionType {" +
				"fallbackReferencePrice=" + this.fallbackReferencePrice +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceSourceDisruptionType  ***********************/
	class PriceSourceDisruptionTypeBuilderImpl implements PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder {
	
		protected FallbackReferencePriceType.FallbackReferencePriceTypeBuilder fallbackReferencePrice;
	
		public PriceSourceDisruptionTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public FallbackReferencePriceType.FallbackReferencePriceTypeBuilder getOrCreateFallbackReferencePrice() {
			FallbackReferencePriceType.FallbackReferencePriceTypeBuilder result;
			if (fallbackReferencePrice!=null) {
				result = fallbackReferencePrice;
			}
			else {
				result = fallbackReferencePrice = FallbackReferencePriceType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		public PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder setFallbackReferencePrice(FallbackReferencePriceType fallbackReferencePrice) {
			this.fallbackReferencePrice = fallbackReferencePrice==null?null:fallbackReferencePrice.toBuilder();
			return this;
		}
		
		@Override
		public PriceSourceDisruptionType build() {
			return new PriceSourceDisruptionType.PriceSourceDisruptionTypeImpl(this);
		}
		
		@Override
		public PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder prune() {
			if (fallbackReferencePrice!=null && !fallbackReferencePrice.prune().hasData()) fallbackReferencePrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFallbackReferencePrice()!=null && getFallbackReferencePrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder o = (PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder) other;
			
			merger.mergeRosetta(getFallbackReferencePrice(), o.getFallbackReferencePrice(), this::setFallbackReferencePrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceSourceDisruptionType _that = getType().cast(o);
		
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceSourceDisruptionTypeBuilder {" +
				"fallbackReferencePrice=" + this.fallbackReferencePrice +
			'}';
		}
	}
}
