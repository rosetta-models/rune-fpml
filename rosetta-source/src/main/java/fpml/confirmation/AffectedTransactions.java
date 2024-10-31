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
import fpml.confirmation.AffectedTransactions;
import fpml.confirmation.AffectedTransactions.AffectedTransactionsBuilder;
import fpml.confirmation.AffectedTransactions.AffectedTransactionsBuilderImpl;
import fpml.confirmation.AffectedTransactions.AffectedTransactionsImpl;
import fpml.confirmation.TradeOrTradeReferenceModel;
import fpml.confirmation.meta.AffectedTransactionsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="AffectedTransactions", builder=AffectedTransactions.AffectedTransactionsBuilderImpl.class, version="${project.version}")
public interface AffectedTransactions extends RosettaModelObject {

	AffectedTransactionsMeta metaData = new AffectedTransactionsMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends TradeOrTradeReferenceModel> getTradeOrTradeReferenceModel();

	/*********************** Build Methods  ***********************/
	AffectedTransactions build();
	
	AffectedTransactions.AffectedTransactionsBuilder toBuilder();
	
	static AffectedTransactions.AffectedTransactionsBuilder builder() {
		return new AffectedTransactions.AffectedTransactionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AffectedTransactions> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AffectedTransactions> getType() {
		return AffectedTransactions.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeOrTradeReferenceModel"), processor, TradeOrTradeReferenceModel.class, getTradeOrTradeReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AffectedTransactionsBuilder extends AffectedTransactions, RosettaModelObjectBuilder {
		TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder getOrCreateTradeOrTradeReferenceModel(int _index);
		List<? extends TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder> getTradeOrTradeReferenceModel();
		AffectedTransactions.AffectedTransactionsBuilder addTradeOrTradeReferenceModel(TradeOrTradeReferenceModel tradeOrTradeReferenceModel0);
		AffectedTransactions.AffectedTransactionsBuilder addTradeOrTradeReferenceModel(TradeOrTradeReferenceModel tradeOrTradeReferenceModel1, int _idx);
		AffectedTransactions.AffectedTransactionsBuilder addTradeOrTradeReferenceModel(List<? extends TradeOrTradeReferenceModel> tradeOrTradeReferenceModel2);
		AffectedTransactions.AffectedTransactionsBuilder setTradeOrTradeReferenceModel(List<? extends TradeOrTradeReferenceModel> tradeOrTradeReferenceModel3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeOrTradeReferenceModel"), processor, TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder.class, getTradeOrTradeReferenceModel());
		}
		

		AffectedTransactions.AffectedTransactionsBuilder prune();
	}

	/*********************** Immutable Implementation of AffectedTransactions  ***********************/
	class AffectedTransactionsImpl implements AffectedTransactions {
		private final List<? extends TradeOrTradeReferenceModel> tradeOrTradeReferenceModel;
		
		protected AffectedTransactionsImpl(AffectedTransactions.AffectedTransactionsBuilder builder) {
			this.tradeOrTradeReferenceModel = ofNullable(builder.getTradeOrTradeReferenceModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeOrTradeReferenceModel")
		public List<? extends TradeOrTradeReferenceModel> getTradeOrTradeReferenceModel() {
			return tradeOrTradeReferenceModel;
		}
		
		@Override
		public AffectedTransactions build() {
			return this;
		}
		
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder toBuilder() {
			AffectedTransactions.AffectedTransactionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AffectedTransactions.AffectedTransactionsBuilder builder) {
			ofNullable(getTradeOrTradeReferenceModel()).ifPresent(builder::setTradeOrTradeReferenceModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AffectedTransactions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeOrTradeReferenceModel, _that.getTradeOrTradeReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeOrTradeReferenceModel != null ? tradeOrTradeReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AffectedTransactions {" +
				"tradeOrTradeReferenceModel=" + this.tradeOrTradeReferenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of AffectedTransactions  ***********************/
	class AffectedTransactionsBuilderImpl implements AffectedTransactions.AffectedTransactionsBuilder {
	
		protected List<TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder> tradeOrTradeReferenceModel = new ArrayList<>();
	
		public AffectedTransactionsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeOrTradeReferenceModel")
		public List<? extends TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder> getTradeOrTradeReferenceModel() {
			return tradeOrTradeReferenceModel;
		}
		
		@Override
		public TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder getOrCreateTradeOrTradeReferenceModel(int _index) {
		
			if (tradeOrTradeReferenceModel==null) {
				this.tradeOrTradeReferenceModel = new ArrayList<>();
			}
			TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder result;
			return getIndex(tradeOrTradeReferenceModel, _index, () -> {
						TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder newTradeOrTradeReferenceModel = TradeOrTradeReferenceModel.builder();
						return newTradeOrTradeReferenceModel;
					});
		}
		
		@Override
		@RosettaAttribute("tradeOrTradeReferenceModel")
		public AffectedTransactions.AffectedTransactionsBuilder addTradeOrTradeReferenceModel(TradeOrTradeReferenceModel tradeOrTradeReferenceModel) {
			if (tradeOrTradeReferenceModel!=null) this.tradeOrTradeReferenceModel.add(tradeOrTradeReferenceModel.toBuilder());
			return this;
		}
		
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder addTradeOrTradeReferenceModel(TradeOrTradeReferenceModel tradeOrTradeReferenceModel, int _idx) {
			getIndex(this.tradeOrTradeReferenceModel, _idx, () -> tradeOrTradeReferenceModel.toBuilder());
			return this;
		}
		@Override 
		public AffectedTransactions.AffectedTransactionsBuilder addTradeOrTradeReferenceModel(List<? extends TradeOrTradeReferenceModel> tradeOrTradeReferenceModels) {
			if (tradeOrTradeReferenceModels != null) {
				for (TradeOrTradeReferenceModel toAdd : tradeOrTradeReferenceModels) {
					this.tradeOrTradeReferenceModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AffectedTransactions.AffectedTransactionsBuilder setTradeOrTradeReferenceModel(List<? extends TradeOrTradeReferenceModel> tradeOrTradeReferenceModels) {
			if (tradeOrTradeReferenceModels == null)  {
				this.tradeOrTradeReferenceModel = new ArrayList<>();
			}
			else {
				this.tradeOrTradeReferenceModel = tradeOrTradeReferenceModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AffectedTransactions build() {
			return new AffectedTransactions.AffectedTransactionsImpl(this);
		}
		
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder prune() {
			tradeOrTradeReferenceModel = tradeOrTradeReferenceModel.stream().filter(b->b!=null).<TradeOrTradeReferenceModel.TradeOrTradeReferenceModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeOrTradeReferenceModel()!=null && getTradeOrTradeReferenceModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AffectedTransactions.AffectedTransactionsBuilder o = (AffectedTransactions.AffectedTransactionsBuilder) other;
			
			merger.mergeRosetta(getTradeOrTradeReferenceModel(), o.getTradeOrTradeReferenceModel(), this::getOrCreateTradeOrTradeReferenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AffectedTransactions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeOrTradeReferenceModel, _that.getTradeOrTradeReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeOrTradeReferenceModel != null ? tradeOrTradeReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AffectedTransactionsBuilder {" +
				"tradeOrTradeReferenceModel=" + this.tradeOrTradeReferenceModel +
			'}';
		}
	}
}
