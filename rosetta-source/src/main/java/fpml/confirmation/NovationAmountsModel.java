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
import fpml.confirmation.NovationAmountsModel;
import fpml.confirmation.NovationAmountsModel.NovationAmountsModelBuilder;
import fpml.confirmation.NovationAmountsModel.NovationAmountsModelBuilderImpl;
import fpml.confirmation.NovationAmountsModel.NovationAmountsModelImpl;
import fpml.confirmation.NovationAmountsOldModel;
import fpml.confirmation.TradeLegSizeChange;
import fpml.confirmation.meta.NovationAmountsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NovationAmountsModel", builder=NovationAmountsModel.NovationAmountsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NovationAmountsModel extends RosettaModelObject {

	NovationAmountsModelMeta metaData = new NovationAmountsModelMeta();

	/*********************** Getter Methods  ***********************/
	NovationAmountsOldModel getNovationAmountsOldModel();
	List<? extends TradeLegSizeChange> getNovationAmount();

	/*********************** Build Methods  ***********************/
	NovationAmountsModel build();
	
	NovationAmountsModel.NovationAmountsModelBuilder toBuilder();
	
	static NovationAmountsModel.NovationAmountsModelBuilder builder() {
		return new NovationAmountsModel.NovationAmountsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NovationAmountsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NovationAmountsModel> getType() {
		return NovationAmountsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("novationAmountsOldModel"), processor, NovationAmountsOldModel.class, getNovationAmountsOldModel());
		processRosetta(path.newSubPath("novationAmount"), processor, TradeLegSizeChange.class, getNovationAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NovationAmountsModelBuilder extends NovationAmountsModel, RosettaModelObjectBuilder {
		NovationAmountsOldModel.NovationAmountsOldModelBuilder getOrCreateNovationAmountsOldModel();
		NovationAmountsOldModel.NovationAmountsOldModelBuilder getNovationAmountsOldModel();
		TradeLegSizeChange.TradeLegSizeChangeBuilder getOrCreateNovationAmount(int _index);
		List<? extends TradeLegSizeChange.TradeLegSizeChangeBuilder> getNovationAmount();
		NovationAmountsModel.NovationAmountsModelBuilder setNovationAmountsOldModel(NovationAmountsOldModel novationAmountsOldModel);
		NovationAmountsModel.NovationAmountsModelBuilder addNovationAmount(TradeLegSizeChange novationAmount0);
		NovationAmountsModel.NovationAmountsModelBuilder addNovationAmount(TradeLegSizeChange novationAmount1, int _idx);
		NovationAmountsModel.NovationAmountsModelBuilder addNovationAmount(List<? extends TradeLegSizeChange> novationAmount2);
		NovationAmountsModel.NovationAmountsModelBuilder setNovationAmount(List<? extends TradeLegSizeChange> novationAmount3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("novationAmountsOldModel"), processor, NovationAmountsOldModel.NovationAmountsOldModelBuilder.class, getNovationAmountsOldModel());
			processRosetta(path.newSubPath("novationAmount"), processor, TradeLegSizeChange.TradeLegSizeChangeBuilder.class, getNovationAmount());
		}
		

		NovationAmountsModel.NovationAmountsModelBuilder prune();
	}

	/*********************** Immutable Implementation of NovationAmountsModel  ***********************/
	class NovationAmountsModelImpl implements NovationAmountsModel {
		private final NovationAmountsOldModel novationAmountsOldModel;
		private final List<? extends TradeLegSizeChange> novationAmount;
		
		protected NovationAmountsModelImpl(NovationAmountsModel.NovationAmountsModelBuilder builder) {
			this.novationAmountsOldModel = ofNullable(builder.getNovationAmountsOldModel()).map(f->f.build()).orElse(null);
			this.novationAmount = ofNullable(builder.getNovationAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("novationAmountsOldModel")
		public NovationAmountsOldModel getNovationAmountsOldModel() {
			return novationAmountsOldModel;
		}
		
		@Override
		@RosettaAttribute("novationAmount")
		public List<? extends TradeLegSizeChange> getNovationAmount() {
			return novationAmount;
		}
		
		@Override
		public NovationAmountsModel build() {
			return this;
		}
		
		@Override
		public NovationAmountsModel.NovationAmountsModelBuilder toBuilder() {
			NovationAmountsModel.NovationAmountsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NovationAmountsModel.NovationAmountsModelBuilder builder) {
			ofNullable(getNovationAmountsOldModel()).ifPresent(builder::setNovationAmountsOldModel);
			ofNullable(getNovationAmount()).ifPresent(builder::setNovationAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsModel _that = getType().cast(o);
		
			if (!Objects.equals(novationAmountsOldModel, _that.getNovationAmountsOldModel())) return false;
			if (!ListEquals.listEquals(novationAmount, _that.getNovationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novationAmountsOldModel != null ? novationAmountsOldModel.hashCode() : 0);
			_result = 31 * _result + (novationAmount != null ? novationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsModel {" +
				"novationAmountsOldModel=" + this.novationAmountsOldModel + ", " +
				"novationAmount=" + this.novationAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of NovationAmountsModel  ***********************/
	class NovationAmountsModelBuilderImpl implements NovationAmountsModel.NovationAmountsModelBuilder {
	
		protected NovationAmountsOldModel.NovationAmountsOldModelBuilder novationAmountsOldModel;
		protected List<TradeLegSizeChange.TradeLegSizeChangeBuilder> novationAmount = new ArrayList<>();
	
		public NovationAmountsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("novationAmountsOldModel")
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder getNovationAmountsOldModel() {
			return novationAmountsOldModel;
		}
		
		@Override
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder getOrCreateNovationAmountsOldModel() {
			NovationAmountsOldModel.NovationAmountsOldModelBuilder result;
			if (novationAmountsOldModel!=null) {
				result = novationAmountsOldModel;
			}
			else {
				result = novationAmountsOldModel = NovationAmountsOldModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationAmount")
		public List<? extends TradeLegSizeChange.TradeLegSizeChangeBuilder> getNovationAmount() {
			return novationAmount;
		}
		
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder getOrCreateNovationAmount(int _index) {
		
			if (novationAmount==null) {
				this.novationAmount = new ArrayList<>();
			}
			TradeLegSizeChange.TradeLegSizeChangeBuilder result;
			return getIndex(novationAmount, _index, () -> {
						TradeLegSizeChange.TradeLegSizeChangeBuilder newNovationAmount = TradeLegSizeChange.builder();
						return newNovationAmount;
					});
		}
		
		@Override
		@RosettaAttribute("novationAmountsOldModel")
		public NovationAmountsModel.NovationAmountsModelBuilder setNovationAmountsOldModel(NovationAmountsOldModel novationAmountsOldModel) {
			this.novationAmountsOldModel = novationAmountsOldModel==null?null:novationAmountsOldModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novationAmount")
		public NovationAmountsModel.NovationAmountsModelBuilder addNovationAmount(TradeLegSizeChange novationAmount) {
			if (novationAmount!=null) this.novationAmount.add(novationAmount.toBuilder());
			return this;
		}
		
		@Override
		public NovationAmountsModel.NovationAmountsModelBuilder addNovationAmount(TradeLegSizeChange novationAmount, int _idx) {
			getIndex(this.novationAmount, _idx, () -> novationAmount.toBuilder());
			return this;
		}
		@Override 
		public NovationAmountsModel.NovationAmountsModelBuilder addNovationAmount(List<? extends TradeLegSizeChange> novationAmounts) {
			if (novationAmounts != null) {
				for (TradeLegSizeChange toAdd : novationAmounts) {
					this.novationAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NovationAmountsModel.NovationAmountsModelBuilder setNovationAmount(List<? extends TradeLegSizeChange> novationAmounts) {
			if (novationAmounts == null)  {
				this.novationAmount = new ArrayList<>();
			}
			else {
				this.novationAmount = novationAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public NovationAmountsModel build() {
			return new NovationAmountsModel.NovationAmountsModelImpl(this);
		}
		
		@Override
		public NovationAmountsModel.NovationAmountsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsModel.NovationAmountsModelBuilder prune() {
			if (novationAmountsOldModel!=null && !novationAmountsOldModel.prune().hasData()) novationAmountsOldModel = null;
			novationAmount = novationAmount.stream().filter(b->b!=null).<TradeLegSizeChange.TradeLegSizeChangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNovationAmountsOldModel()!=null && getNovationAmountsOldModel().hasData()) return true;
			if (getNovationAmount()!=null && getNovationAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsModel.NovationAmountsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NovationAmountsModel.NovationAmountsModelBuilder o = (NovationAmountsModel.NovationAmountsModelBuilder) other;
			
			merger.mergeRosetta(getNovationAmountsOldModel(), o.getNovationAmountsOldModel(), this::setNovationAmountsOldModel);
			merger.mergeRosetta(getNovationAmount(), o.getNovationAmount(), this::getOrCreateNovationAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsModel _that = getType().cast(o);
		
			if (!Objects.equals(novationAmountsOldModel, _that.getNovationAmountsOldModel())) return false;
			if (!ListEquals.listEquals(novationAmount, _that.getNovationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novationAmountsOldModel != null ? novationAmountsOldModel.hashCode() : 0);
			_result = 31 * _result + (novationAmount != null ? novationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsModelBuilder {" +
				"novationAmountsOldModel=" + this.novationAmountsOldModel + ", " +
				"novationAmount=" + this.novationAmount +
			'}';
		}
	}
}
