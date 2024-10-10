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
import fpml.confirmation.FallbackReferencePrice;
import fpml.confirmation.FallbackReferencePrice.FallbackReferencePriceBuilder;
import fpml.confirmation.FallbackReferencePrice.FallbackReferencePriceBuilderImpl;
import fpml.confirmation.FallbackReferencePrice.FallbackReferencePriceImpl;
import fpml.confirmation.FxFallbackReferencePrice;
import fpml.confirmation.FxFallbackReferencePrice.FxFallbackReferencePriceBuilder;
import fpml.confirmation.FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl;
import fpml.confirmation.FxFallbackReferencePrice.FxFallbackReferencePriceImpl;
import fpml.confirmation.PrioritizedRateSourceModel;
import fpml.confirmation.meta.FallbackReferencePriceMeta;


/**
 * If present indicates alternative price sources
 * @version ${project.version}
 */
@RosettaDataType(value="FallbackReferencePrice", builder=FallbackReferencePrice.FallbackReferencePriceBuilderImpl.class, version="${project.version}")
public interface FallbackReferencePrice extends FxFallbackReferencePrice {

	FallbackReferencePriceMeta metaData = new FallbackReferencePriceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FallbackReferencePrice build();
	
	FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder();
	
	static FallbackReferencePrice.FallbackReferencePriceBuilder builder() {
		return new FallbackReferencePrice.FallbackReferencePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FallbackReferencePrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FallbackReferencePrice> getType() {
		return FallbackReferencePrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("prioritizedRateSourceModel"), processor, PrioritizedRateSourceModel.class, getPrioritizedRateSourceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FallbackReferencePriceBuilder extends FallbackReferencePrice, FxFallbackReferencePrice.FxFallbackReferencePriceBuilder {
		FallbackReferencePrice.FallbackReferencePriceBuilder setPrioritizedRateSourceModel(PrioritizedRateSourceModel prioritizedRateSourceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("prioritizedRateSourceModel"), processor, PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder.class, getPrioritizedRateSourceModel());
		}
		

		FallbackReferencePrice.FallbackReferencePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FallbackReferencePrice  ***********************/
	class FallbackReferencePriceImpl extends FxFallbackReferencePrice.FxFallbackReferencePriceImpl implements FallbackReferencePrice {
		
		protected FallbackReferencePriceImpl(FallbackReferencePrice.FallbackReferencePriceBuilder builder) {
			super(builder);
		}
		
		@Override
		public FallbackReferencePrice build() {
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder() {
			FallbackReferencePrice.FallbackReferencePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FallbackReferencePrice.FallbackReferencePriceBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "FallbackReferencePrice {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FallbackReferencePrice  ***********************/
	class FallbackReferencePriceBuilderImpl extends FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl  implements FallbackReferencePrice.FallbackReferencePriceBuilder {
	
	
		public FallbackReferencePriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("prioritizedRateSourceModel")
		public FallbackReferencePrice.FallbackReferencePriceBuilder setPrioritizedRateSourceModel(PrioritizedRateSourceModel prioritizedRateSourceModel) {
			this.prioritizedRateSourceModel = prioritizedRateSourceModel==null?null:prioritizedRateSourceModel.toBuilder();
			return this;
		}
		
		@Override
		public FallbackReferencePrice build() {
			return new FallbackReferencePrice.FallbackReferencePriceImpl(this);
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder prune() {
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
		public FallbackReferencePrice.FallbackReferencePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FallbackReferencePrice.FallbackReferencePriceBuilder o = (FallbackReferencePrice.FallbackReferencePriceBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "FallbackReferencePriceBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
