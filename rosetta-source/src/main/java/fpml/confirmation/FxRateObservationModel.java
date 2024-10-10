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
import fpml.confirmation.FxAverageRateObservation;
import fpml.confirmation.FxRateObservationModel;
import fpml.confirmation.FxRateObservationModel.FxRateObservationModelBuilder;
import fpml.confirmation.FxRateObservationModel.FxRateObservationModelBuilderImpl;
import fpml.confirmation.FxRateObservationModel.FxRateObservationModelImpl;
import fpml.confirmation.StrikeQuoteBasisEnum;
import fpml.confirmation.meta.FxRateObservationModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The elements common to FX rate observation.
 * @version ${project.version}
 */
@RosettaDataType(value="FxRateObservationModel", builder=FxRateObservationModel.FxRateObservationModelBuilderImpl.class, version="${project.version}")
public interface FxRateObservationModel extends RosettaModelObject {

	FxRateObservationModelMeta metaData = new FxRateObservationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * One or more specific rate observation dates.
	 */
	List<? extends FxAverageRateObservation> getRateObservation();
	/**
	 * The method by which observed rate values are quoted, in terms of the option put/call currencies. In the absence of this element, rate observations are assumed to be quoted as per the option strikeQuoteBasis.
	 */
	StrikeQuoteBasisEnum getRateObservationQuoteBasis();

	/*********************** Build Methods  ***********************/
	FxRateObservationModel build();
	
	FxRateObservationModel.FxRateObservationModelBuilder toBuilder();
	
	static FxRateObservationModel.FxRateObservationModelBuilder builder() {
		return new FxRateObservationModel.FxRateObservationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRateObservationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxRateObservationModel> getType() {
		return FxRateObservationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateObservation"), processor, FxAverageRateObservation.class, getRateObservation());
		processor.processBasic(path.newSubPath("rateObservationQuoteBasis"), StrikeQuoteBasisEnum.class, getRateObservationQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRateObservationModelBuilder extends FxRateObservationModel, RosettaModelObjectBuilder {
		FxAverageRateObservation.FxAverageRateObservationBuilder getOrCreateRateObservation(int _index);
		List<? extends FxAverageRateObservation.FxAverageRateObservationBuilder> getRateObservation();
		FxRateObservationModel.FxRateObservationModelBuilder addRateObservation(FxAverageRateObservation rateObservation0);
		FxRateObservationModel.FxRateObservationModelBuilder addRateObservation(FxAverageRateObservation rateObservation1, int _idx);
		FxRateObservationModel.FxRateObservationModelBuilder addRateObservation(List<? extends FxAverageRateObservation> rateObservation2);
		FxRateObservationModel.FxRateObservationModelBuilder setRateObservation(List<? extends FxAverageRateObservation> rateObservation3);
		FxRateObservationModel.FxRateObservationModelBuilder setRateObservationQuoteBasis(StrikeQuoteBasisEnum rateObservationQuoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateObservation"), processor, FxAverageRateObservation.FxAverageRateObservationBuilder.class, getRateObservation());
			processor.processBasic(path.newSubPath("rateObservationQuoteBasis"), StrikeQuoteBasisEnum.class, getRateObservationQuoteBasis(), this);
		}
		

		FxRateObservationModel.FxRateObservationModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxRateObservationModel  ***********************/
	class FxRateObservationModelImpl implements FxRateObservationModel {
		private final List<? extends FxAverageRateObservation> rateObservation;
		private final StrikeQuoteBasisEnum rateObservationQuoteBasis;
		
		protected FxRateObservationModelImpl(FxRateObservationModel.FxRateObservationModelBuilder builder) {
			this.rateObservation = ofNullable(builder.getRateObservation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateObservationQuoteBasis = builder.getRateObservationQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("rateObservation")
		public List<? extends FxAverageRateObservation> getRateObservation() {
			return rateObservation;
		}
		
		@Override
		@RosettaAttribute("rateObservationQuoteBasis")
		public StrikeQuoteBasisEnum getRateObservationQuoteBasis() {
			return rateObservationQuoteBasis;
		}
		
		@Override
		public FxRateObservationModel build() {
			return this;
		}
		
		@Override
		public FxRateObservationModel.FxRateObservationModelBuilder toBuilder() {
			FxRateObservationModel.FxRateObservationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateObservationModel.FxRateObservationModelBuilder builder) {
			ofNullable(getRateObservation()).ifPresent(builder::setRateObservation);
			ofNullable(getRateObservationQuoteBasis()).ifPresent(builder::setRateObservationQuoteBasis);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateObservationModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(rateObservation, _that.getRateObservation())) return false;
			if (!Objects.equals(rateObservationQuoteBasis, _that.getRateObservationQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateObservation != null ? rateObservation.hashCode() : 0);
			_result = 31 * _result + (rateObservationQuoteBasis != null ? rateObservationQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateObservationModel {" +
				"rateObservation=" + this.rateObservation + ", " +
				"rateObservationQuoteBasis=" + this.rateObservationQuoteBasis +
			'}';
		}
	}

	/*********************** Builder Implementation of FxRateObservationModel  ***********************/
	class FxRateObservationModelBuilderImpl implements FxRateObservationModel.FxRateObservationModelBuilder {
	
		protected List<FxAverageRateObservation.FxAverageRateObservationBuilder> rateObservation = new ArrayList<>();
		protected StrikeQuoteBasisEnum rateObservationQuoteBasis;
	
		public FxRateObservationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rateObservation")
		public List<? extends FxAverageRateObservation.FxAverageRateObservationBuilder> getRateObservation() {
			return rateObservation;
		}
		
		public FxAverageRateObservation.FxAverageRateObservationBuilder getOrCreateRateObservation(int _index) {
		
			if (rateObservation==null) {
				this.rateObservation = new ArrayList<>();
			}
			FxAverageRateObservation.FxAverageRateObservationBuilder result;
			return getIndex(rateObservation, _index, () -> {
						FxAverageRateObservation.FxAverageRateObservationBuilder newRateObservation = FxAverageRateObservation.builder();
						return newRateObservation;
					});
		}
		
		@Override
		@RosettaAttribute("rateObservationQuoteBasis")
		public StrikeQuoteBasisEnum getRateObservationQuoteBasis() {
			return rateObservationQuoteBasis;
		}
		
		@Override
		public FxRateObservationModel.FxRateObservationModelBuilder addRateObservation(FxAverageRateObservation rateObservation) {
			if (rateObservation!=null) this.rateObservation.add(rateObservation.toBuilder());
			return this;
		}
		
		@Override
		public FxRateObservationModel.FxRateObservationModelBuilder addRateObservation(FxAverageRateObservation rateObservation, int _idx) {
			getIndex(this.rateObservation, _idx, () -> rateObservation.toBuilder());
			return this;
		}
		@Override 
		public FxRateObservationModel.FxRateObservationModelBuilder addRateObservation(List<? extends FxAverageRateObservation> rateObservations) {
			if (rateObservations != null) {
				for (FxAverageRateObservation toAdd : rateObservations) {
					this.rateObservation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("rateObservation")
		public FxRateObservationModel.FxRateObservationModelBuilder setRateObservation(List<? extends FxAverageRateObservation> rateObservations) {
			if (rateObservations == null)  {
				this.rateObservation = new ArrayList<>();
			}
			else {
				this.rateObservation = rateObservations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("rateObservationQuoteBasis")
		public FxRateObservationModel.FxRateObservationModelBuilder setRateObservationQuoteBasis(StrikeQuoteBasisEnum rateObservationQuoteBasis) {
			this.rateObservationQuoteBasis = rateObservationQuoteBasis==null?null:rateObservationQuoteBasis;
			return this;
		}
		
		@Override
		public FxRateObservationModel build() {
			return new FxRateObservationModel.FxRateObservationModelImpl(this);
		}
		
		@Override
		public FxRateObservationModel.FxRateObservationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservationModel.FxRateObservationModelBuilder prune() {
			rateObservation = rateObservation.stream().filter(b->b!=null).<FxAverageRateObservation.FxAverageRateObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRateObservation()!=null && getRateObservation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateObservationQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservationModel.FxRateObservationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxRateObservationModel.FxRateObservationModelBuilder o = (FxRateObservationModel.FxRateObservationModelBuilder) other;
			
			merger.mergeRosetta(getRateObservation(), o.getRateObservation(), this::getOrCreateRateObservation);
			
			merger.mergeBasic(getRateObservationQuoteBasis(), o.getRateObservationQuoteBasis(), this::setRateObservationQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateObservationModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(rateObservation, _that.getRateObservation())) return false;
			if (!Objects.equals(rateObservationQuoteBasis, _that.getRateObservationQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateObservation != null ? rateObservation.hashCode() : 0);
			_result = 31 * _result + (rateObservationQuoteBasis != null ? rateObservationQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateObservationModelBuilder {" +
				"rateObservation=" + this.rateObservation + ", " +
				"rateObservationQuoteBasis=" + this.rateObservationQuoteBasis +
			'}';
		}
	}
}
