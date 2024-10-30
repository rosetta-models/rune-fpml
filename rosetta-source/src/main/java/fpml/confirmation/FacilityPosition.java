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
import fpml.confirmation.CurrentPriorCommitmentModel;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.FacilityPosition.FacilityPositionBuilder;
import fpml.confirmation.FacilityPosition.FacilityPositionBuilderImpl;
import fpml.confirmation.FacilityPosition.FacilityPositionImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.meta.FacilityPositionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents current/prior facility commitment amounts on both the global and lender position levels.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FacilityPosition", builder=FacilityPosition.FacilityPositionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FacilityPosition extends RosettaModelObject {

	FacilityPositionMeta metaData = new FacilityPositionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique facility identifier.
	 */
	FacilityReference getFacilityReference();
	CurrentPriorCommitmentModel getCurrentPriorCommitmentModel();

	/*********************** Build Methods  ***********************/
	FacilityPosition build();
	
	FacilityPosition.FacilityPositionBuilder toBuilder();
	
	static FacilityPosition.FacilityPositionBuilder builder() {
		return new FacilityPosition.FacilityPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityPosition> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityPosition> getType() {
		return FacilityPosition.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("currentPriorCommitmentModel"), processor, CurrentPriorCommitmentModel.class, getCurrentPriorCommitmentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityPositionBuilder extends FacilityPosition, RosettaModelObjectBuilder {
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder getOrCreateCurrentPriorCommitmentModel();
		CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder getCurrentPriorCommitmentModel();
		FacilityPosition.FacilityPositionBuilder setFacilityReference(FacilityReference facilityReference);
		FacilityPosition.FacilityPositionBuilder setCurrentPriorCommitmentModel(CurrentPriorCommitmentModel currentPriorCommitmentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("currentPriorCommitmentModel"), processor, CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder.class, getCurrentPriorCommitmentModel());
		}
		

		FacilityPosition.FacilityPositionBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityPosition  ***********************/
	class FacilityPositionImpl implements FacilityPosition {
		private final FacilityReference facilityReference;
		private final CurrentPriorCommitmentModel currentPriorCommitmentModel;
		
		protected FacilityPositionImpl(FacilityPosition.FacilityPositionBuilder builder) {
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
			this.currentPriorCommitmentModel = ofNullable(builder.getCurrentPriorCommitmentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		@RosettaAttribute("currentPriorCommitmentModel")
		public CurrentPriorCommitmentModel getCurrentPriorCommitmentModel() {
			return currentPriorCommitmentModel;
		}
		
		@Override
		public FacilityPosition build() {
			return this;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder toBuilder() {
			FacilityPosition.FacilityPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityPosition.FacilityPositionBuilder builder) {
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
			ofNullable(getCurrentPriorCommitmentModel()).ifPresent(builder::setCurrentPriorCommitmentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityPosition _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(currentPriorCommitmentModel, _that.getCurrentPriorCommitmentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (currentPriorCommitmentModel != null ? currentPriorCommitmentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityPosition {" +
				"facilityReference=" + this.facilityReference + ", " +
				"currentPriorCommitmentModel=" + this.currentPriorCommitmentModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityPosition  ***********************/
	class FacilityPositionBuilderImpl implements FacilityPosition.FacilityPositionBuilder {
	
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		protected CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder currentPriorCommitmentModel;
	
		public FacilityPositionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currentPriorCommitmentModel")
		public CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder getCurrentPriorCommitmentModel() {
			return currentPriorCommitmentModel;
		}
		
		@Override
		public CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder getOrCreateCurrentPriorCommitmentModel() {
			CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder result;
			if (currentPriorCommitmentModel!=null) {
				result = currentPriorCommitmentModel;
			}
			else {
				result = currentPriorCommitmentModel = CurrentPriorCommitmentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityPosition.FacilityPositionBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currentPriorCommitmentModel")
		public FacilityPosition.FacilityPositionBuilder setCurrentPriorCommitmentModel(CurrentPriorCommitmentModel currentPriorCommitmentModel) {
			this.currentPriorCommitmentModel = currentPriorCommitmentModel==null?null:currentPriorCommitmentModel.toBuilder();
			return this;
		}
		
		@Override
		public FacilityPosition build() {
			return new FacilityPosition.FacilityPositionImpl(this);
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityPosition.FacilityPositionBuilder prune() {
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			if (currentPriorCommitmentModel!=null && !currentPriorCommitmentModel.prune().hasData()) currentPriorCommitmentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			if (getCurrentPriorCommitmentModel()!=null && getCurrentPriorCommitmentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityPosition.FacilityPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityPosition.FacilityPositionBuilder o = (FacilityPosition.FacilityPositionBuilder) other;
			
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			merger.mergeRosetta(getCurrentPriorCommitmentModel(), o.getCurrentPriorCommitmentModel(), this::setCurrentPriorCommitmentModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityPosition _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(currentPriorCommitmentModel, _that.getCurrentPriorCommitmentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (currentPriorCommitmentModel != null ? currentPriorCommitmentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityPositionBuilder {" +
				"facilityReference=" + this.facilityReference + ", " +
				"currentPriorCommitmentModel=" + this.currentPriorCommitmentModel +
			'}';
		}
	}
}
