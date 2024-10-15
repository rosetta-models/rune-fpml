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
import fpml.confirmation.BondChoiceModel;
import fpml.confirmation.BondEquityModel;
import fpml.confirmation.BondEquityModel.BondEquityModelBuilder;
import fpml.confirmation.BondEquityModel.BondEquityModelBuilderImpl;
import fpml.confirmation.BondEquityModel.BondEquityModelImpl;
import fpml.confirmation.EquityAsset;
import fpml.confirmation.meta.BondEquityModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group that allows us to specify that a repo contract can reference bond or equity instruments.
 * @version ${project.version}
 */
@RosettaDataType(value="BondEquityModel", builder=BondEquityModel.BondEquityModelBuilderImpl.class, version="${project.version}")
public interface BondEquityModel extends RosettaModelObject {

	BondEquityModelMeta metaData = new BondEquityModelMeta();

	/*********************** Getter Methods  ***********************/
	BondChoiceModel getBondChoiceModel();
	EquityAsset getEquity();

	/*********************** Build Methods  ***********************/
	BondEquityModel build();
	
	BondEquityModel.BondEquityModelBuilder toBuilder();
	
	static BondEquityModel.BondEquityModelBuilder builder() {
		return new BondEquityModel.BondEquityModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondEquityModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BondEquityModel> getType() {
		return BondEquityModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bondChoiceModel"), processor, BondChoiceModel.class, getBondChoiceModel());
		processRosetta(path.newSubPath("equity"), processor, EquityAsset.class, getEquity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondEquityModelBuilder extends BondEquityModel, RosettaModelObjectBuilder {
		BondChoiceModel.BondChoiceModelBuilder getOrCreateBondChoiceModel();
		BondChoiceModel.BondChoiceModelBuilder getBondChoiceModel();
		EquityAsset.EquityAssetBuilder getOrCreateEquity();
		EquityAsset.EquityAssetBuilder getEquity();
		BondEquityModel.BondEquityModelBuilder setBondChoiceModel(BondChoiceModel bondChoiceModel);
		BondEquityModel.BondEquityModelBuilder setEquity(EquityAsset equity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bondChoiceModel"), processor, BondChoiceModel.BondChoiceModelBuilder.class, getBondChoiceModel());
			processRosetta(path.newSubPath("equity"), processor, EquityAsset.EquityAssetBuilder.class, getEquity());
		}
		

		BondEquityModel.BondEquityModelBuilder prune();
	}

	/*********************** Immutable Implementation of BondEquityModel  ***********************/
	class BondEquityModelImpl implements BondEquityModel {
		private final BondChoiceModel bondChoiceModel;
		private final EquityAsset equity;
		
		protected BondEquityModelImpl(BondEquityModel.BondEquityModelBuilder builder) {
			this.bondChoiceModel = ofNullable(builder.getBondChoiceModel()).map(f->f.build()).orElse(null);
			this.equity = ofNullable(builder.getEquity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bondChoiceModel")
		public BondChoiceModel getBondChoiceModel() {
			return bondChoiceModel;
		}
		
		@Override
		@RosettaAttribute("equity")
		public EquityAsset getEquity() {
			return equity;
		}
		
		@Override
		public BondEquityModel build() {
			return this;
		}
		
		@Override
		public BondEquityModel.BondEquityModelBuilder toBuilder() {
			BondEquityModel.BondEquityModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondEquityModel.BondEquityModelBuilder builder) {
			ofNullable(getBondChoiceModel()).ifPresent(builder::setBondChoiceModel);
			ofNullable(getEquity()).ifPresent(builder::setEquity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondEquityModel _that = getType().cast(o);
		
			if (!Objects.equals(bondChoiceModel, _that.getBondChoiceModel())) return false;
			if (!Objects.equals(equity, _that.getEquity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondChoiceModel != null ? bondChoiceModel.hashCode() : 0);
			_result = 31 * _result + (equity != null ? equity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondEquityModel {" +
				"bondChoiceModel=" + this.bondChoiceModel + ", " +
				"equity=" + this.equity +
			'}';
		}
	}

	/*********************** Builder Implementation of BondEquityModel  ***********************/
	class BondEquityModelBuilderImpl implements BondEquityModel.BondEquityModelBuilder {
	
		protected BondChoiceModel.BondChoiceModelBuilder bondChoiceModel;
		protected EquityAsset.EquityAssetBuilder equity;
	
		public BondEquityModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bondChoiceModel")
		public BondChoiceModel.BondChoiceModelBuilder getBondChoiceModel() {
			return bondChoiceModel;
		}
		
		@Override
		public BondChoiceModel.BondChoiceModelBuilder getOrCreateBondChoiceModel() {
			BondChoiceModel.BondChoiceModelBuilder result;
			if (bondChoiceModel!=null) {
				result = bondChoiceModel;
			}
			else {
				result = bondChoiceModel = BondChoiceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equity")
		public EquityAsset.EquityAssetBuilder getEquity() {
			return equity;
		}
		
		@Override
		public EquityAsset.EquityAssetBuilder getOrCreateEquity() {
			EquityAsset.EquityAssetBuilder result;
			if (equity!=null) {
				result = equity;
			}
			else {
				result = equity = EquityAsset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bondChoiceModel")
		public BondEquityModel.BondEquityModelBuilder setBondChoiceModel(BondChoiceModel bondChoiceModel) {
			this.bondChoiceModel = bondChoiceModel==null?null:bondChoiceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equity")
		public BondEquityModel.BondEquityModelBuilder setEquity(EquityAsset equity) {
			this.equity = equity==null?null:equity.toBuilder();
			return this;
		}
		
		@Override
		public BondEquityModel build() {
			return new BondEquityModel.BondEquityModelImpl(this);
		}
		
		@Override
		public BondEquityModel.BondEquityModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondEquityModel.BondEquityModelBuilder prune() {
			if (bondChoiceModel!=null && !bondChoiceModel.prune().hasData()) bondChoiceModel = null;
			if (equity!=null && !equity.prune().hasData()) equity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBondChoiceModel()!=null && getBondChoiceModel().hasData()) return true;
			if (getEquity()!=null && getEquity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondEquityModel.BondEquityModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondEquityModel.BondEquityModelBuilder o = (BondEquityModel.BondEquityModelBuilder) other;
			
			merger.mergeRosetta(getBondChoiceModel(), o.getBondChoiceModel(), this::setBondChoiceModel);
			merger.mergeRosetta(getEquity(), o.getEquity(), this::setEquity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondEquityModel _that = getType().cast(o);
		
			if (!Objects.equals(bondChoiceModel, _that.getBondChoiceModel())) return false;
			if (!Objects.equals(equity, _that.getEquity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondChoiceModel != null ? bondChoiceModel.hashCode() : 0);
			_result = 31 * _result + (equity != null ? equity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondEquityModelBuilder {" +
				"bondChoiceModel=" + this.bondChoiceModel + ", " +
				"equity=" + this.equity +
			'}';
		}
	}
}
