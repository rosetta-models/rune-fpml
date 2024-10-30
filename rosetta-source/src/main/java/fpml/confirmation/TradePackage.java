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
import fpml.confirmation.Approvals;
import fpml.confirmation.PackageHeader;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradePackage;
import fpml.confirmation.TradePackage.TradePackageBuilder;
import fpml.confirmation.TradePackage.TradePackageBuilderImpl;
import fpml.confirmation.TradePackage.TradePackageImpl;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.meta.TradePackageMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A bundle of trades collected together into a single unit for reporting.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradePackage", builder=TradePackage.TradePackageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradePackage extends RosettaModelObject {

	TradePackageMeta metaData = new TradePackageMeta();

	/*********************** Getter Methods  ***********************/
	PackageHeader getPackageHeader();
	List<? extends Trade> getTrade();
	List<? extends TradeReferenceInformationModel> getTradeReferenceInformationModel();
	List<? extends TradeIdentifier> getTradeIdentifier();
	/**
	 * A container for approval states in the workflow.
	 */
	Approvals getApprovals();

	/*********************** Build Methods  ***********************/
	TradePackage build();
	
	TradePackage.TradePackageBuilder toBuilder();
	
	static TradePackage.TradePackageBuilder builder() {
		return new TradePackage.TradePackageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradePackage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradePackage> getType() {
		return TradePackage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("packageHeader"), processor, PackageHeader.class, getPackageHeader());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("approvals"), processor, Approvals.class, getApprovals());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradePackageBuilder extends TradePackage, RosettaModelObjectBuilder {
		PackageHeader.PackageHeaderBuilder getOrCreatePackageHeader();
		PackageHeader.PackageHeaderBuilder getPackageHeader();
		Trade.TradeBuilder getOrCreateTrade(int _index);
		List<? extends Trade.TradeBuilder> getTrade();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel(int _index);
		List<? extends TradeReferenceInformationModel.TradeReferenceInformationModelBuilder> getTradeReferenceInformationModel();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier();
		Approvals.ApprovalsBuilder getOrCreateApprovals();
		Approvals.ApprovalsBuilder getApprovals();
		TradePackage.TradePackageBuilder setPackageHeader(PackageHeader packageHeader);
		TradePackage.TradePackageBuilder addTrade(Trade trade0);
		TradePackage.TradePackageBuilder addTrade(Trade trade1, int _idx);
		TradePackage.TradePackageBuilder addTrade(List<? extends Trade> trade2);
		TradePackage.TradePackageBuilder setTrade(List<? extends Trade> trade3);
		TradePackage.TradePackageBuilder addTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel0);
		TradePackage.TradePackageBuilder addTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel1, int _idx);
		TradePackage.TradePackageBuilder addTradeReferenceInformationModel(List<? extends TradeReferenceInformationModel> tradeReferenceInformationModel2);
		TradePackage.TradePackageBuilder setTradeReferenceInformationModel(List<? extends TradeReferenceInformationModel> tradeReferenceInformationModel3);
		TradePackage.TradePackageBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier0);
		TradePackage.TradePackageBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier1, int _idx);
		TradePackage.TradePackageBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier2);
		TradePackage.TradePackageBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier3);
		TradePackage.TradePackageBuilder setApprovals(Approvals approvals);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("packageHeader"), processor, PackageHeader.PackageHeaderBuilder.class, getPackageHeader());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("approvals"), processor, Approvals.ApprovalsBuilder.class, getApprovals());
		}
		

		TradePackage.TradePackageBuilder prune();
	}

	/*********************** Immutable Implementation of TradePackage  ***********************/
	class TradePackageImpl implements TradePackage {
		private final PackageHeader packageHeader;
		private final List<? extends Trade> trade;
		private final List<? extends TradeReferenceInformationModel> tradeReferenceInformationModel;
		private final List<? extends TradeIdentifier> tradeIdentifier;
		private final Approvals approvals;
		
		protected TradePackageImpl(TradePackage.TradePackageBuilder builder) {
			this.packageHeader = ofNullable(builder.getPackageHeader()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeReferenceInformationModel = ofNullable(builder.getTradeReferenceInformationModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.approvals = ofNullable(builder.getApprovals()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("packageHeader")
		public PackageHeader getPackageHeader() {
			return packageHeader;
		}
		
		@Override
		@RosettaAttribute("trade")
		public List<? extends Trade> getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public List<? extends TradeReferenceInformationModel> getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Approvals getApprovals() {
			return approvals;
		}
		
		@Override
		public TradePackage build() {
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder toBuilder() {
			TradePackage.TradePackageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradePackage.TradePackageBuilder builder) {
			ofNullable(getPackageHeader()).ifPresent(builder::setPackageHeader);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradeReferenceInformationModel()).ifPresent(builder::setTradeReferenceInformationModel);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getApprovals()).ifPresent(builder::setApprovals);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradePackage _that = getType().cast(o);
		
			if (!Objects.equals(packageHeader, _that.getPackageHeader())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageHeader != null ? packageHeader.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradePackage {" +
				"packageHeader=" + this.packageHeader + ", " +
				"trade=" + this.trade + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"approvals=" + this.approvals +
			'}';
		}
	}

	/*********************** Builder Implementation of TradePackage  ***********************/
	class TradePackageBuilderImpl implements TradePackage.TradePackageBuilder {
	
		protected PackageHeader.PackageHeaderBuilder packageHeader;
		protected List<Trade.TradeBuilder> trade = new ArrayList<>();
		protected List<TradeReferenceInformationModel.TradeReferenceInformationModelBuilder> tradeReferenceInformationModel = new ArrayList<>();
		protected List<TradeIdentifier.TradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Approvals.ApprovalsBuilder approvals;
	
		public TradePackageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("packageHeader")
		public PackageHeader.PackageHeaderBuilder getPackageHeader() {
			return packageHeader;
		}
		
		@Override
		public PackageHeader.PackageHeaderBuilder getOrCreatePackageHeader() {
			PackageHeader.PackageHeaderBuilder result;
			if (packageHeader!=null) {
				result = packageHeader;
			}
			else {
				result = packageHeader = PackageHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		public List<? extends Trade.TradeBuilder> getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade(int _index) {
		
			if (trade==null) {
				this.trade = new ArrayList<>();
			}
			Trade.TradeBuilder result;
			return getIndex(trade, _index, () -> {
						Trade.TradeBuilder newTrade = Trade.builder();
						return newTrade;
					});
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public List<? extends TradeReferenceInformationModel.TradeReferenceInformationModelBuilder> getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel(int _index) {
		
			if (tradeReferenceInformationModel==null) {
				this.tradeReferenceInformationModel = new ArrayList<>();
			}
			TradeReferenceInformationModel.TradeReferenceInformationModelBuilder result;
			return getIndex(tradeReferenceInformationModel, _index, () -> {
						TradeReferenceInformationModel.TradeReferenceInformationModelBuilder newTradeReferenceInformationModel = TradeReferenceInformationModel.builder();
						return newTradeReferenceInformationModel;
					});
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			TradeIdentifier.TradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newTradeIdentifier = TradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Approvals.ApprovalsBuilder getApprovals() {
			return approvals;
		}
		
		@Override
		public Approvals.ApprovalsBuilder getOrCreateApprovals() {
			Approvals.ApprovalsBuilder result;
			if (approvals!=null) {
				result = approvals;
			}
			else {
				result = approvals = Approvals.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageHeader")
		public TradePackage.TradePackageBuilder setPackageHeader(PackageHeader packageHeader) {
			this.packageHeader = packageHeader==null?null:packageHeader.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public TradePackage.TradePackageBuilder addTrade(Trade trade) {
			if (trade!=null) this.trade.add(trade.toBuilder());
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTrade(Trade trade, int _idx) {
			getIndex(this.trade, _idx, () -> trade.toBuilder());
			return this;
		}
		@Override 
		public TradePackage.TradePackageBuilder addTrade(List<? extends Trade> trades) {
			if (trades != null) {
				for (Trade toAdd : trades) {
					this.trade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradePackage.TradePackageBuilder setTrade(List<? extends Trade> trades) {
			if (trades == null)  {
				this.trade = new ArrayList<>();
			}
			else {
				this.trade = trades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradePackage.TradePackageBuilder addTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			if (tradeReferenceInformationModel!=null) this.tradeReferenceInformationModel.add(tradeReferenceInformationModel.toBuilder());
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel, int _idx) {
			getIndex(this.tradeReferenceInformationModel, _idx, () -> tradeReferenceInformationModel.toBuilder());
			return this;
		}
		@Override 
		public TradePackage.TradePackageBuilder addTradeReferenceInformationModel(List<? extends TradeReferenceInformationModel> tradeReferenceInformationModels) {
			if (tradeReferenceInformationModels != null) {
				for (TradeReferenceInformationModel toAdd : tradeReferenceInformationModels) {
					this.tradeReferenceInformationModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradePackage.TradePackageBuilder setTradeReferenceInformationModel(List<? extends TradeReferenceInformationModel> tradeReferenceInformationModels) {
			if (tradeReferenceInformationModels == null)  {
				this.tradeReferenceInformationModel = new ArrayList<>();
			}
			else {
				this.tradeReferenceInformationModel = tradeReferenceInformationModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public TradePackage.TradePackageBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradePackage.TradePackageBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (TradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradePackage.TradePackageBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("approvals")
		public TradePackage.TradePackageBuilder setApprovals(Approvals approvals) {
			this.approvals = approvals==null?null:approvals.toBuilder();
			return this;
		}
		
		@Override
		public TradePackage build() {
			return new TradePackage.TradePackageImpl(this);
		}
		
		@Override
		public TradePackage.TradePackageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradePackage.TradePackageBuilder prune() {
			if (packageHeader!=null && !packageHeader.prune().hasData()) packageHeader = null;
			trade = trade.stream().filter(b->b!=null).<Trade.TradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeReferenceInformationModel = tradeReferenceInformationModel.stream().filter(b->b!=null).<TradeReferenceInformationModel.TradeReferenceInformationModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (approvals!=null && !approvals.prune().hasData()) approvals = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPackageHeader()!=null && getPackageHeader().hasData()) return true;
			if (getTrade()!=null && getTrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeReferenceInformationModel()!=null && getTradeReferenceInformationModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getApprovals()!=null && getApprovals().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradePackage.TradePackageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradePackage.TradePackageBuilder o = (TradePackage.TradePackageBuilder) other;
			
			merger.mergeRosetta(getPackageHeader(), o.getPackageHeader(), this::setPackageHeader);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::getOrCreateTrade);
			merger.mergeRosetta(getTradeReferenceInformationModel(), o.getTradeReferenceInformationModel(), this::getOrCreateTradeReferenceInformationModel);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getApprovals(), o.getApprovals(), this::setApprovals);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradePackage _that = getType().cast(o);
		
			if (!Objects.equals(packageHeader, _that.getPackageHeader())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageHeader != null ? packageHeader.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradePackageBuilder {" +
				"packageHeader=" + this.packageHeader + ", " +
				"trade=" + this.trade + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"approvals=" + this.approvals +
			'}';
		}
	}
}
