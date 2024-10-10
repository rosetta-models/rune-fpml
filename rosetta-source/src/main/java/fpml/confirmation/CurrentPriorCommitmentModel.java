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
import fpml.confirmation.CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder;
import fpml.confirmation.CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilderImpl;
import fpml.confirmation.CurrentPriorCommitmentModel.CurrentPriorCommitmentModelImpl;
import fpml.confirmation.FacilityCommitment;
import fpml.confirmation.meta.CurrentPriorCommitmentModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that represents current and prior global commitment break-down. The model requires global amounts and can optionally represent lender-specific share amounts.
 * @version ${project.version}
 */
@RosettaDataType(value="CurrentPriorCommitmentModel", builder=CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilderImpl.class, version="${project.version}")
public interface CurrentPriorCommitmentModel extends RosettaModelObject {

	CurrentPriorCommitmentModelMeta metaData = new CurrentPriorCommitmentModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The global and share amount of principal commitment. This is after any referenced business events have taken place.
	 */
	FacilityCommitment getCommitment();
	/**
	 * The global and share amount of principal commitment. This is prior to any referenced business events.
	 */
	FacilityCommitment getPriorCommitment();

	/*********************** Build Methods  ***********************/
	CurrentPriorCommitmentModel build();
	
	CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder toBuilder();
	
	static CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder builder() {
		return new CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CurrentPriorCommitmentModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CurrentPriorCommitmentModel> getType() {
		return CurrentPriorCommitmentModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commitment"), processor, FacilityCommitment.class, getCommitment());
		processRosetta(path.newSubPath("priorCommitment"), processor, FacilityCommitment.class, getPriorCommitment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CurrentPriorCommitmentModelBuilder extends CurrentPriorCommitmentModel, RosettaModelObjectBuilder {
		FacilityCommitment.FacilityCommitmentBuilder getOrCreateCommitment();
		FacilityCommitment.FacilityCommitmentBuilder getCommitment();
		FacilityCommitment.FacilityCommitmentBuilder getOrCreatePriorCommitment();
		FacilityCommitment.FacilityCommitmentBuilder getPriorCommitment();
		CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder setCommitment(FacilityCommitment commitment);
		CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder setPriorCommitment(FacilityCommitment priorCommitment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getCommitment());
			processRosetta(path.newSubPath("priorCommitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getPriorCommitment());
		}
		

		CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder prune();
	}

	/*********************** Immutable Implementation of CurrentPriorCommitmentModel  ***********************/
	class CurrentPriorCommitmentModelImpl implements CurrentPriorCommitmentModel {
		private final FacilityCommitment commitment;
		private final FacilityCommitment priorCommitment;
		
		protected CurrentPriorCommitmentModelImpl(CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder builder) {
			this.commitment = ofNullable(builder.getCommitment()).map(f->f.build()).orElse(null);
			this.priorCommitment = ofNullable(builder.getPriorCommitment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commitment")
		public FacilityCommitment getCommitment() {
			return commitment;
		}
		
		@Override
		@RosettaAttribute("priorCommitment")
		public FacilityCommitment getPriorCommitment() {
			return priorCommitment;
		}
		
		@Override
		public CurrentPriorCommitmentModel build() {
			return this;
		}
		
		@Override
		public CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder toBuilder() {
			CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder builder) {
			ofNullable(getCommitment()).ifPresent(builder::setCommitment);
			ofNullable(getPriorCommitment()).ifPresent(builder::setPriorCommitment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrentPriorCommitmentModel _that = getType().cast(o);
		
			if (!Objects.equals(commitment, _that.getCommitment())) return false;
			if (!Objects.equals(priorCommitment, _that.getPriorCommitment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commitment != null ? commitment.hashCode() : 0);
			_result = 31 * _result + (priorCommitment != null ? priorCommitment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrentPriorCommitmentModel {" +
				"commitment=" + this.commitment + ", " +
				"priorCommitment=" + this.priorCommitment +
			'}';
		}
	}

	/*********************** Builder Implementation of CurrentPriorCommitmentModel  ***********************/
	class CurrentPriorCommitmentModelBuilderImpl implements CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder {
	
		protected FacilityCommitment.FacilityCommitmentBuilder commitment;
		protected FacilityCommitment.FacilityCommitmentBuilder priorCommitment;
	
		public CurrentPriorCommitmentModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commitment")
		public FacilityCommitment.FacilityCommitmentBuilder getCommitment() {
			return commitment;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder getOrCreateCommitment() {
			FacilityCommitment.FacilityCommitmentBuilder result;
			if (commitment!=null) {
				result = commitment;
			}
			else {
				result = commitment = FacilityCommitment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priorCommitment")
		public FacilityCommitment.FacilityCommitmentBuilder getPriorCommitment() {
			return priorCommitment;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder getOrCreatePriorCommitment() {
			FacilityCommitment.FacilityCommitmentBuilder result;
			if (priorCommitment!=null) {
				result = priorCommitment;
			}
			else {
				result = priorCommitment = FacilityCommitment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitment")
		public CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder setCommitment(FacilityCommitment commitment) {
			this.commitment = commitment==null?null:commitment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("priorCommitment")
		public CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder setPriorCommitment(FacilityCommitment priorCommitment) {
			this.priorCommitment = priorCommitment==null?null:priorCommitment.toBuilder();
			return this;
		}
		
		@Override
		public CurrentPriorCommitmentModel build() {
			return new CurrentPriorCommitmentModel.CurrentPriorCommitmentModelImpl(this);
		}
		
		@Override
		public CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder prune() {
			if (commitment!=null && !commitment.prune().hasData()) commitment = null;
			if (priorCommitment!=null && !priorCommitment.prune().hasData()) priorCommitment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommitment()!=null && getCommitment().hasData()) return true;
			if (getPriorCommitment()!=null && getPriorCommitment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder o = (CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder) other;
			
			merger.mergeRosetta(getCommitment(), o.getCommitment(), this::setCommitment);
			merger.mergeRosetta(getPriorCommitment(), o.getPriorCommitment(), this::setPriorCommitment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrentPriorCommitmentModel _that = getType().cast(o);
		
			if (!Objects.equals(commitment, _that.getCommitment())) return false;
			if (!Objects.equals(priorCommitment, _that.getPriorCommitment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commitment != null ? commitment.hashCode() : 0);
			_result = 31 * _result + (priorCommitment != null ? priorCommitment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrentPriorCommitmentModelBuilder {" +
				"commitment=" + this.commitment + ", " +
				"priorCommitment=" + this.priorCommitment +
			'}';
		}
	}
}
