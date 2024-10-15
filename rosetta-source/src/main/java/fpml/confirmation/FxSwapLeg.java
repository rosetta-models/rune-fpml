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
import fpml.confirmation.FxCoreDetailsModel;
import fpml.confirmation.FxSwapLeg;
import fpml.confirmation.FxSwapLeg.FxSwapLegBuilder;
import fpml.confirmation.FxSwapLeg.FxSwapLegBuilderImpl;
import fpml.confirmation.FxSwapLeg.FxSwapLegImpl;
import fpml.confirmation.Leg;
import fpml.confirmation.Leg.LegBuilder;
import fpml.confirmation.Leg.LegBuilderImpl;
import fpml.confirmation.Leg.LegImpl;
import fpml.confirmation.PartyTradeIdentifierReference;
import fpml.confirmation.meta.FxSwapLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxSwapLeg", builder=FxSwapLeg.FxSwapLegBuilderImpl.class, version="${project.version}")
public interface FxSwapLeg extends Leg {

	FxSwapLegMeta metaData = new FxSwapLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to a party trade ID. This is provided in case the message creator wishes to record that the swap leg is assocatiated with a particular trade identifier; typically this is used for identifying a USI assocatied wih the leg.
	 */
	List<? extends PartyTradeIdentifierReference> getTradeIdentifierReference();
	FxCoreDetailsModel getFxCoreDetailsModel();

	/*********************** Build Methods  ***********************/
	FxSwapLeg build();
	
	FxSwapLeg.FxSwapLegBuilder toBuilder();
	
	static FxSwapLeg.FxSwapLegBuilder builder() {
		return new FxSwapLeg.FxSwapLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSwapLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxSwapLeg> getType() {
		return FxSwapLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("tradeIdentifierReference"), processor, PartyTradeIdentifierReference.class, getTradeIdentifierReference());
		processRosetta(path.newSubPath("fxCoreDetailsModel"), processor, FxCoreDetailsModel.class, getFxCoreDetailsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSwapLegBuilder extends FxSwapLeg, Leg.LegBuilder {
		PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getOrCreateTradeIdentifierReference(int _index);
		List<? extends PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder> getTradeIdentifierReference();
		FxCoreDetailsModel.FxCoreDetailsModelBuilder getOrCreateFxCoreDetailsModel();
		FxCoreDetailsModel.FxCoreDetailsModelBuilder getFxCoreDetailsModel();
		FxSwapLeg.FxSwapLegBuilder setId(String id);
		FxSwapLeg.FxSwapLegBuilder addTradeIdentifierReference(PartyTradeIdentifierReference tradeIdentifierReference0);
		FxSwapLeg.FxSwapLegBuilder addTradeIdentifierReference(PartyTradeIdentifierReference tradeIdentifierReference1, int _idx);
		FxSwapLeg.FxSwapLegBuilder addTradeIdentifierReference(List<? extends PartyTradeIdentifierReference> tradeIdentifierReference2);
		FxSwapLeg.FxSwapLegBuilder setTradeIdentifierReference(List<? extends PartyTradeIdentifierReference> tradeIdentifierReference3);
		FxSwapLeg.FxSwapLegBuilder setFxCoreDetailsModel(FxCoreDetailsModel fxCoreDetailsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("tradeIdentifierReference"), processor, PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder.class, getTradeIdentifierReference());
			processRosetta(path.newSubPath("fxCoreDetailsModel"), processor, FxCoreDetailsModel.FxCoreDetailsModelBuilder.class, getFxCoreDetailsModel());
		}
		

		FxSwapLeg.FxSwapLegBuilder prune();
	}

	/*********************** Immutable Implementation of FxSwapLeg  ***********************/
	class FxSwapLegImpl extends Leg.LegImpl implements FxSwapLeg {
		private final List<? extends PartyTradeIdentifierReference> tradeIdentifierReference;
		private final FxCoreDetailsModel fxCoreDetailsModel;
		
		protected FxSwapLegImpl(FxSwapLeg.FxSwapLegBuilder builder) {
			super(builder);
			this.tradeIdentifierReference = ofNullable(builder.getTradeIdentifierReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fxCoreDetailsModel = ofNullable(builder.getFxCoreDetailsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifierReference")
		public List<? extends PartyTradeIdentifierReference> getTradeIdentifierReference() {
			return tradeIdentifierReference;
		}
		
		@Override
		@RosettaAttribute("fxCoreDetailsModel")
		public FxCoreDetailsModel getFxCoreDetailsModel() {
			return fxCoreDetailsModel;
		}
		
		@Override
		public FxSwapLeg build() {
			return this;
		}
		
		@Override
		public FxSwapLeg.FxSwapLegBuilder toBuilder() {
			FxSwapLeg.FxSwapLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSwapLeg.FxSwapLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeIdentifierReference()).ifPresent(builder::setTradeIdentifierReference);
			ofNullable(getFxCoreDetailsModel()).ifPresent(builder::setFxCoreDetailsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSwapLeg _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifierReference, _that.getTradeIdentifierReference())) return false;
			if (!Objects.equals(fxCoreDetailsModel, _that.getFxCoreDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifierReference != null ? tradeIdentifierReference.hashCode() : 0);
			_result = 31 * _result + (fxCoreDetailsModel != null ? fxCoreDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSwapLeg {" +
				"tradeIdentifierReference=" + this.tradeIdentifierReference + ", " +
				"fxCoreDetailsModel=" + this.fxCoreDetailsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxSwapLeg  ***********************/
	class FxSwapLegBuilderImpl extends Leg.LegBuilderImpl  implements FxSwapLeg.FxSwapLegBuilder {
	
		protected List<PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder> tradeIdentifierReference = new ArrayList<>();
		protected FxCoreDetailsModel.FxCoreDetailsModelBuilder fxCoreDetailsModel;
	
		public FxSwapLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifierReference")
		public List<? extends PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder> getTradeIdentifierReference() {
			return tradeIdentifierReference;
		}
		
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getOrCreateTradeIdentifierReference(int _index) {
		
			if (tradeIdentifierReference==null) {
				this.tradeIdentifierReference = new ArrayList<>();
			}
			PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder result;
			return getIndex(tradeIdentifierReference, _index, () -> {
						PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder newTradeIdentifierReference = PartyTradeIdentifierReference.builder();
						return newTradeIdentifierReference;
					});
		}
		
		@Override
		@RosettaAttribute("fxCoreDetailsModel")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder getFxCoreDetailsModel() {
			return fxCoreDetailsModel;
		}
		
		@Override
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder getOrCreateFxCoreDetailsModel() {
			FxCoreDetailsModel.FxCoreDetailsModelBuilder result;
			if (fxCoreDetailsModel!=null) {
				result = fxCoreDetailsModel;
			}
			else {
				result = fxCoreDetailsModel = FxCoreDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxSwapLeg.FxSwapLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public FxSwapLeg.FxSwapLegBuilder addTradeIdentifierReference(PartyTradeIdentifierReference tradeIdentifierReference) {
			if (tradeIdentifierReference!=null) this.tradeIdentifierReference.add(tradeIdentifierReference.toBuilder());
			return this;
		}
		
		@Override
		public FxSwapLeg.FxSwapLegBuilder addTradeIdentifierReference(PartyTradeIdentifierReference tradeIdentifierReference, int _idx) {
			getIndex(this.tradeIdentifierReference, _idx, () -> tradeIdentifierReference.toBuilder());
			return this;
		}
		@Override 
		public FxSwapLeg.FxSwapLegBuilder addTradeIdentifierReference(List<? extends PartyTradeIdentifierReference> tradeIdentifierReferences) {
			if (tradeIdentifierReferences != null) {
				for (PartyTradeIdentifierReference toAdd : tradeIdentifierReferences) {
					this.tradeIdentifierReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("tradeIdentifierReference")
		public FxSwapLeg.FxSwapLegBuilder setTradeIdentifierReference(List<? extends PartyTradeIdentifierReference> tradeIdentifierReferences) {
			if (tradeIdentifierReferences == null)  {
				this.tradeIdentifierReference = new ArrayList<>();
			}
			else {
				this.tradeIdentifierReference = tradeIdentifierReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fxCoreDetailsModel")
		public FxSwapLeg.FxSwapLegBuilder setFxCoreDetailsModel(FxCoreDetailsModel fxCoreDetailsModel) {
			this.fxCoreDetailsModel = fxCoreDetailsModel==null?null:fxCoreDetailsModel.toBuilder();
			return this;
		}
		
		@Override
		public FxSwapLeg build() {
			return new FxSwapLeg.FxSwapLegImpl(this);
		}
		
		@Override
		public FxSwapLeg.FxSwapLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSwapLeg.FxSwapLegBuilder prune() {
			super.prune();
			tradeIdentifierReference = tradeIdentifierReference.stream().filter(b->b!=null).<PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fxCoreDetailsModel!=null && !fxCoreDetailsModel.prune().hasData()) fxCoreDetailsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeIdentifierReference()!=null && getTradeIdentifierReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFxCoreDetailsModel()!=null && getFxCoreDetailsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSwapLeg.FxSwapLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxSwapLeg.FxSwapLegBuilder o = (FxSwapLeg.FxSwapLegBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifierReference(), o.getTradeIdentifierReference(), this::getOrCreateTradeIdentifierReference);
			merger.mergeRosetta(getFxCoreDetailsModel(), o.getFxCoreDetailsModel(), this::setFxCoreDetailsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSwapLeg _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifierReference, _that.getTradeIdentifierReference())) return false;
			if (!Objects.equals(fxCoreDetailsModel, _that.getFxCoreDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifierReference != null ? tradeIdentifierReference.hashCode() : 0);
			_result = 31 * _result + (fxCoreDetailsModel != null ? fxCoreDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSwapLegBuilder {" +
				"tradeIdentifierReference=" + this.tradeIdentifierReference + ", " +
				"fxCoreDetailsModel=" + this.fxCoreDetailsModel +
			'}' + " " + super.toString();
		}
	}
}
