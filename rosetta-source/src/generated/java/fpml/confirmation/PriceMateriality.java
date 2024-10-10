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
import fpml.confirmation.FxDisruptionEvent;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventBuilder;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventBuilderImpl;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventImpl;
import fpml.confirmation.PriceMateriality;
import fpml.confirmation.PriceMateriality.PriceMaterialityBuilder;
import fpml.confirmation.PriceMateriality.PriceMaterialityBuilderImpl;
import fpml.confirmation.PriceMateriality.PriceMaterialityImpl;
import fpml.confirmation.PrioritizedRateSourceModel;
import fpml.confirmation.meta.PriceMaterialityMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the require price materiality percentage for the rate source to be considered valid. A structure describing the criteria for price materiality.
 * @version ${project.version}
 */
@RosettaDataType(value="PriceMateriality", builder=PriceMateriality.PriceMaterialityBuilderImpl.class, version="${project.version}")
public interface PriceMateriality extends FxDisruptionEvent {

	PriceMaterialityMeta metaData = new PriceMaterialityMeta();

	/*********************** Getter Methods  ***********************/
	PrioritizedRateSourceModel getPrioritizedRateSourceModel();
	BigDecimal getPercentage();

	/*********************** Build Methods  ***********************/
	PriceMateriality build();
	
	PriceMateriality.PriceMaterialityBuilder toBuilder();
	
	static PriceMateriality.PriceMaterialityBuilder builder() {
		return new PriceMateriality.PriceMaterialityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceMateriality> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PriceMateriality> getType() {
		return PriceMateriality.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("prioritizedRateSourceModel"), processor, PrioritizedRateSourceModel.class, getPrioritizedRateSourceModel());
		processor.processBasic(path.newSubPath("percentage"), BigDecimal.class, getPercentage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceMaterialityBuilder extends PriceMateriality, FxDisruptionEvent.FxDisruptionEventBuilder {
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder getOrCreatePrioritizedRateSourceModel();
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder getPrioritizedRateSourceModel();
		PriceMateriality.PriceMaterialityBuilder setPrioritizedRateSourceModel(PrioritizedRateSourceModel prioritizedRateSourceModel);
		PriceMateriality.PriceMaterialityBuilder setPercentage(BigDecimal percentage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("prioritizedRateSourceModel"), processor, PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder.class, getPrioritizedRateSourceModel());
			processor.processBasic(path.newSubPath("percentage"), BigDecimal.class, getPercentage(), this);
		}
		

		PriceMateriality.PriceMaterialityBuilder prune();
	}

	/*********************** Immutable Implementation of PriceMateriality  ***********************/
	class PriceMaterialityImpl extends FxDisruptionEvent.FxDisruptionEventImpl implements PriceMateriality {
		private final PrioritizedRateSourceModel prioritizedRateSourceModel;
		private final BigDecimal percentage;
		
		protected PriceMaterialityImpl(PriceMateriality.PriceMaterialityBuilder builder) {
			super(builder);
			this.prioritizedRateSourceModel = ofNullable(builder.getPrioritizedRateSourceModel()).map(f->f.build()).orElse(null);
			this.percentage = builder.getPercentage();
		}
		
		@Override
		@RosettaAttribute("prioritizedRateSourceModel")
		public PrioritizedRateSourceModel getPrioritizedRateSourceModel() {
			return prioritizedRateSourceModel;
		}
		
		@Override
		@RosettaAttribute("percentage")
		public BigDecimal getPercentage() {
			return percentage;
		}
		
		@Override
		public PriceMateriality build() {
			return this;
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder toBuilder() {
			PriceMateriality.PriceMaterialityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceMateriality.PriceMaterialityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPrioritizedRateSourceModel()).ifPresent(builder::setPrioritizedRateSourceModel);
			ofNullable(getPercentage()).ifPresent(builder::setPercentage);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PriceMateriality _that = getType().cast(o);
		
			if (!Objects.equals(prioritizedRateSourceModel, _that.getPrioritizedRateSourceModel())) return false;
			if (!Objects.equals(percentage, _that.getPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (prioritizedRateSourceModel != null ? prioritizedRateSourceModel.hashCode() : 0);
			_result = 31 * _result + (percentage != null ? percentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceMateriality {" +
				"prioritizedRateSourceModel=" + this.prioritizedRateSourceModel + ", " +
				"percentage=" + this.percentage +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PriceMateriality  ***********************/
	class PriceMaterialityBuilderImpl extends FxDisruptionEvent.FxDisruptionEventBuilderImpl  implements PriceMateriality.PriceMaterialityBuilder {
	
		protected PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder prioritizedRateSourceModel;
		protected BigDecimal percentage;
	
		public PriceMaterialityBuilderImpl() {
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
		@RosettaAttribute("percentage")
		public BigDecimal getPercentage() {
			return percentage;
		}
		
		@Override
		@RosettaAttribute("prioritizedRateSourceModel")
		public PriceMateriality.PriceMaterialityBuilder setPrioritizedRateSourceModel(PrioritizedRateSourceModel prioritizedRateSourceModel) {
			this.prioritizedRateSourceModel = prioritizedRateSourceModel==null?null:prioritizedRateSourceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("percentage")
		public PriceMateriality.PriceMaterialityBuilder setPercentage(BigDecimal percentage) {
			this.percentage = percentage==null?null:percentage;
			return this;
		}
		
		@Override
		public PriceMateriality build() {
			return new PriceMateriality.PriceMaterialityImpl(this);
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceMateriality.PriceMaterialityBuilder prune() {
			super.prune();
			if (prioritizedRateSourceModel!=null && !prioritizedRateSourceModel.prune().hasData()) prioritizedRateSourceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPrioritizedRateSourceModel()!=null && getPrioritizedRateSourceModel().hasData()) return true;
			if (getPercentage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceMateriality.PriceMaterialityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PriceMateriality.PriceMaterialityBuilder o = (PriceMateriality.PriceMaterialityBuilder) other;
			
			merger.mergeRosetta(getPrioritizedRateSourceModel(), o.getPrioritizedRateSourceModel(), this::setPrioritizedRateSourceModel);
			
			merger.mergeBasic(getPercentage(), o.getPercentage(), this::setPercentage);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PriceMateriality _that = getType().cast(o);
		
			if (!Objects.equals(prioritizedRateSourceModel, _that.getPrioritizedRateSourceModel())) return false;
			if (!Objects.equals(percentage, _that.getPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (prioritizedRateSourceModel != null ? prioritizedRateSourceModel.hashCode() : 0);
			_result = 31 * _result + (percentage != null ? percentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceMaterialityBuilder {" +
				"prioritizedRateSourceModel=" + this.prioritizedRateSourceModel + ", " +
				"percentage=" + this.percentage +
			'}' + " " + super.toString();
		}
	}
}
