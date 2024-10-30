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
import fpml.confirmation.FxDisruptionFallback;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilder;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilderImpl;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackImpl;
import fpml.confirmation.FxFallbackReferencePrice;
import fpml.confirmation.FxFallbackReferencePrice.FxFallbackReferencePriceBuilder;
import fpml.confirmation.FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl;
import fpml.confirmation.FxFallbackReferencePrice.FxFallbackReferencePriceImpl;
import fpml.confirmation.PrioritizedRateSourceModel;
import fpml.confirmation.meta.FxFallbackReferencePriceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes an alternative set of price sources
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxFallbackReferencePrice", builder=FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxFallbackReferencePrice extends FxDisruptionFallback {

	FxFallbackReferencePriceMeta metaData = new FxFallbackReferencePriceMeta();

	/*********************** Getter Methods  ***********************/
	PrioritizedRateSourceModel getPrioritizedRateSourceModel();

	/*********************** Build Methods  ***********************/
	FxFallbackReferencePrice build();
	
	FxFallbackReferencePrice.FxFallbackReferencePriceBuilder toBuilder();
	
	static FxFallbackReferencePrice.FxFallbackReferencePriceBuilder builder() {
		return new FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFallbackReferencePrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFallbackReferencePrice> getType() {
		return FxFallbackReferencePrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("prioritizedRateSourceModel"), processor, PrioritizedRateSourceModel.class, getPrioritizedRateSourceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFallbackReferencePriceBuilder extends FxFallbackReferencePrice, FxDisruptionFallback.FxDisruptionFallbackBuilder {
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder getOrCreatePrioritizedRateSourceModel();
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder getPrioritizedRateSourceModel();
		FxFallbackReferencePrice.FxFallbackReferencePriceBuilder setPrioritizedRateSourceModel(PrioritizedRateSourceModel prioritizedRateSourceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("prioritizedRateSourceModel"), processor, PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder.class, getPrioritizedRateSourceModel());
		}
		

		FxFallbackReferencePrice.FxFallbackReferencePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FxFallbackReferencePrice  ***********************/
	class FxFallbackReferencePriceImpl extends FxDisruptionFallback.FxDisruptionFallbackImpl implements FxFallbackReferencePrice {
		private final PrioritizedRateSourceModel prioritizedRateSourceModel;
		
		protected FxFallbackReferencePriceImpl(FxFallbackReferencePrice.FxFallbackReferencePriceBuilder builder) {
			super(builder);
			this.prioritizedRateSourceModel = ofNullable(builder.getPrioritizedRateSourceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("prioritizedRateSourceModel")
		public PrioritizedRateSourceModel getPrioritizedRateSourceModel() {
			return prioritizedRateSourceModel;
		}
		
		@Override
		public FxFallbackReferencePrice build() {
			return this;
		}
		
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder toBuilder() {
			FxFallbackReferencePrice.FxFallbackReferencePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFallbackReferencePrice.FxFallbackReferencePriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPrioritizedRateSourceModel()).ifPresent(builder::setPrioritizedRateSourceModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFallbackReferencePrice _that = getType().cast(o);
		
			if (!Objects.equals(prioritizedRateSourceModel, _that.getPrioritizedRateSourceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (prioritizedRateSourceModel != null ? prioritizedRateSourceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFallbackReferencePrice {" +
				"prioritizedRateSourceModel=" + this.prioritizedRateSourceModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxFallbackReferencePrice  ***********************/
	class FxFallbackReferencePriceBuilderImpl extends FxDisruptionFallback.FxDisruptionFallbackBuilderImpl  implements FxFallbackReferencePrice.FxFallbackReferencePriceBuilder {
	
		protected PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder prioritizedRateSourceModel;
	
		public FxFallbackReferencePriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("prioritizedRateSourceModel")
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder getPrioritizedRateSourceModel() {
			return prioritizedRateSourceModel;
		}
		
		@Override
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder getOrCreatePrioritizedRateSourceModel() {
			PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder result;
			if (prioritizedRateSourceModel!=null) {
				result = prioritizedRateSourceModel;
			}
			else {
				result = prioritizedRateSourceModel = PrioritizedRateSourceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prioritizedRateSourceModel")
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder setPrioritizedRateSourceModel(PrioritizedRateSourceModel prioritizedRateSourceModel) {
			this.prioritizedRateSourceModel = prioritizedRateSourceModel==null?null:prioritizedRateSourceModel.toBuilder();
			return this;
		}
		
		@Override
		public FxFallbackReferencePrice build() {
			return new FxFallbackReferencePrice.FxFallbackReferencePriceImpl(this);
		}
		
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder prune() {
			super.prune();
			if (prioritizedRateSourceModel!=null && !prioritizedRateSourceModel.prune().hasData()) prioritizedRateSourceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPrioritizedRateSourceModel()!=null && getPrioritizedRateSourceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxFallbackReferencePrice.FxFallbackReferencePriceBuilder o = (FxFallbackReferencePrice.FxFallbackReferencePriceBuilder) other;
			
			merger.mergeRosetta(getPrioritizedRateSourceModel(), o.getPrioritizedRateSourceModel(), this::setPrioritizedRateSourceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFallbackReferencePrice _that = getType().cast(o);
		
			if (!Objects.equals(prioritizedRateSourceModel, _that.getPrioritizedRateSourceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (prioritizedRateSourceModel != null ? prioritizedRateSourceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFallbackReferencePriceBuilder {" +
				"prioritizedRateSourceModel=" + this.prioritizedRateSourceModel +
			'}' + " " + super.toString();
		}
	}
}
