package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.CurrentPriorCommitmentModel;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder;
import fpml.confirmation.FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilderImpl;
import fpml.confirmation.FacilityOutstandingsPosition.FacilityOutstandingsPositionImpl;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.FacilityPosition.FacilityPositionBuilder;
import fpml.confirmation.FacilityPosition.FacilityPositionBuilderImpl;
import fpml.confirmation.FacilityPosition.FacilityPositionImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.OutstandingsPosition;
import fpml.confirmation.meta.FacilityOutstandingsPositionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents current/prior facility commitment and outstanding amounts on both the global and lender position levels.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityOutstandingsPosition", builder=FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilderImpl.class, version="${project.version}")
public interface FacilityOutstandingsPosition extends FacilityPosition {

	FacilityOutstandingsPositionMeta metaData = new FacilityOutstandingsPositionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure used to define all positions held by the lender at the loan contract level. This structure is design to hold either some or all loan contracts.
	 */
	List<? extends OutstandingsPosition> getOutstandingsPosition();

	/*********************** Build Methods  ***********************/
	FacilityOutstandingsPosition build();
	
	FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder toBuilder();
	
	static FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder builder() {
		return new FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityOutstandingsPosition> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityOutstandingsPosition> getType() {
		return FacilityOutstandingsPosition.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("currentPriorCommitmentModel"), processor, CurrentPriorCommitmentModel.class, getCurrentPriorCommitmentModel());
		processRosetta(path.newSubPath("outstandingsPosition"), processor, OutstandingsPosition.class, getOutstandingsPosition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityOutstandingsPositionBuilder extends FacilityOutstandingsPosition, FacilityPosition.FacilityPositionBuilder {
		OutstandingsPosition.OutstandingsPositionBuilder getOrCreateOutstandingsPosition(int _index);
		List<? extends OutstandingsPosition.OutstandingsPositionBuilder> getOutstandingsPosition();
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder setFacilityReference(FacilityReference facilityReference);
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder setCurrentPriorCommitmentModel(CurrentPriorCommitmentModel currentPriorCommitmentModel);
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder addOutstandingsPosition(OutstandingsPosition outstandingsPosition0);
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder addOutstandingsPosition(OutstandingsPosition outstandingsPosition1, int _idx);
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder addOutstandingsPosition(List<? extends OutstandingsPosition> outstandingsPosition2);
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder setOutstandingsPosition(List<? extends OutstandingsPosition> outstandingsPosition3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("currentPriorCommitmentModel"), processor, CurrentPriorCommitmentModel.CurrentPriorCommitmentModelBuilder.class, getCurrentPriorCommitmentModel());
			processRosetta(path.newSubPath("outstandingsPosition"), processor, OutstandingsPosition.OutstandingsPositionBuilder.class, getOutstandingsPosition());
		}
		

		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityOutstandingsPosition  ***********************/
	class FacilityOutstandingsPositionImpl extends FacilityPosition.FacilityPositionImpl implements FacilityOutstandingsPosition {
		private final List<? extends OutstandingsPosition> outstandingsPosition;
		
		protected FacilityOutstandingsPositionImpl(FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder builder) {
			super(builder);
			this.outstandingsPosition = ofNullable(builder.getOutstandingsPosition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("outstandingsPosition")
		public List<? extends OutstandingsPosition> getOutstandingsPosition() {
			return outstandingsPosition;
		}
		
		@Override
		public FacilityOutstandingsPosition build() {
			return this;
		}
		
		@Override
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder toBuilder() {
			FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOutstandingsPosition()).ifPresent(builder::setOutstandingsPosition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityOutstandingsPosition _that = getType().cast(o);
		
			if (!ListEquals.listEquals(outstandingsPosition, _that.getOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (outstandingsPosition != null ? outstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityOutstandingsPosition {" +
				"outstandingsPosition=" + this.outstandingsPosition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityOutstandingsPosition  ***********************/
	class FacilityOutstandingsPositionBuilderImpl extends FacilityPosition.FacilityPositionBuilderImpl  implements FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder {
	
		protected List<OutstandingsPosition.OutstandingsPositionBuilder> outstandingsPosition = new ArrayList<>();
	
		public FacilityOutstandingsPositionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("outstandingsPosition")
		public List<? extends OutstandingsPosition.OutstandingsPositionBuilder> getOutstandingsPosition() {
			return outstandingsPosition;
		}
		
		@Override
		public OutstandingsPosition.OutstandingsPositionBuilder getOrCreateOutstandingsPosition(int _index) {
		
			if (outstandingsPosition==null) {
				this.outstandingsPosition = new ArrayList<>();
			}
			OutstandingsPosition.OutstandingsPositionBuilder result;
			return getIndex(outstandingsPosition, _index, () -> {
						OutstandingsPosition.OutstandingsPositionBuilder newOutstandingsPosition = OutstandingsPosition.builder();
						return newOutstandingsPosition;
					});
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currentPriorCommitmentModel")
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder setCurrentPriorCommitmentModel(CurrentPriorCommitmentModel currentPriorCommitmentModel) {
			this.currentPriorCommitmentModel = currentPriorCommitmentModel==null?null:currentPriorCommitmentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("outstandingsPosition")
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder addOutstandingsPosition(OutstandingsPosition outstandingsPosition) {
			if (outstandingsPosition!=null) this.outstandingsPosition.add(outstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder addOutstandingsPosition(OutstandingsPosition outstandingsPosition, int _idx) {
			getIndex(this.outstandingsPosition, _idx, () -> outstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder addOutstandingsPosition(List<? extends OutstandingsPosition> outstandingsPositions) {
			if (outstandingsPositions != null) {
				for (OutstandingsPosition toAdd : outstandingsPositions) {
					this.outstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder setOutstandingsPosition(List<? extends OutstandingsPosition> outstandingsPositions) {
			if (outstandingsPositions == null)  {
				this.outstandingsPosition = new ArrayList<>();
			}
			else {
				this.outstandingsPosition = outstandingsPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FacilityOutstandingsPosition build() {
			return new FacilityOutstandingsPosition.FacilityOutstandingsPositionImpl(this);
		}
		
		@Override
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder prune() {
			super.prune();
			outstandingsPosition = outstandingsPosition.stream().filter(b->b!=null).<OutstandingsPosition.OutstandingsPositionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOutstandingsPosition()!=null && getOutstandingsPosition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder o = (FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder) other;
			
			merger.mergeRosetta(getOutstandingsPosition(), o.getOutstandingsPosition(), this::getOrCreateOutstandingsPosition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityOutstandingsPosition _that = getType().cast(o);
		
			if (!ListEquals.listEquals(outstandingsPosition, _that.getOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (outstandingsPosition != null ? outstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityOutstandingsPositionBuilder {" +
				"outstandingsPosition=" + this.outstandingsPosition +
			'}' + " " + super.toString();
		}
	}
}
