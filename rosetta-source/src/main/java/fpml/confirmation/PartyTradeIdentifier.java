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
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.LinkId;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PartyTradeIdentifier.PartyTradeIdentifierBuilder;
import fpml.confirmation.PartyTradeIdentifier.PartyTradeIdentifierBuilderImpl;
import fpml.confirmation.PartyTradeIdentifier.PartyTradeIdentifierImpl;
import fpml.confirmation.ProductComponentIdentifier;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradeIdentifier.TradeIdentifierBuilder;
import fpml.confirmation.TradeIdentifier.TradeIdentifierBuilderImpl;
import fpml.confirmation.TradeIdentifier.TradeIdentifierImpl;
import fpml.confirmation.TradeIdentifierExtended;
import fpml.confirmation.TradeIdentifierSequence;
import fpml.confirmation.meta.PartyTradeIdentifierMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining one or more trade identifiers allocated to the trade by a party. A link identifier allows the trade to be associated with other related trades, e.g. trades forming part of a larger structured transaction. It is expected that for external communication of trade there will be only one tradeId sent in the document per party.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyTradeIdentifier", builder=PartyTradeIdentifier.PartyTradeIdentifierBuilderImpl.class, version="${project.version}")
public interface PartyTradeIdentifier extends TradeIdentifier {

	PartyTradeIdentifierMeta metaData = new PartyTradeIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A link identifier allowing the trade to be associated with other related trades, e.g. the linkId may contain a tradeId for an associated trade or several related trades may be given the same linkId. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
	 */
	List<? extends LinkId> getLinkId();
	/**
	 * The trade id of the allocated trade. This is used by the block trade to reference the allocated trade.
	 */
	List<? extends TradeIdentifier> getAllocationTradeId();
	/**
	 * The trade id of a resulting trade (beta or gamma trade) that resulted from this trade during a clearing or similar operation (e.g. prime brokerage).
	 */
	List<? extends TradeIdentifierExtended> getResultingTradeId();
	/**
	 * The trade id of the block trade. This is used by each one of the allocated trades to reference the block trade. This element can also represent the trade id of the parent trade for N-level allocations. In the case, this element is only used to model N-level allocations in which the trade acts as block and allocated trade at the same time. This basically means the ability to allocate a block trade to multiple allocation trades, and then allocate these in turn to other allocation trades (and so on if desired).
	 */
	TradeIdentifier getBlockTradeId();
	/**
	 * The trade id of the trade(s) upon which this was based, for example the ID of the trade that was submitted for clearing if this is a cleared trade, or of the original trade if this was novated or cancelled and rebooked, or the list of trades that were netted or compressed together in the case of a compression event. The originatingEvent will explain why the trade was created; the existence and number of originatingTradeId elements should correspond to the originatingEvent, and they should be interpreted using that field. If the trade is inside a business event structure (such as a novation or a compression event) this element shuld not be populated; instead the event shoudl be used to represent the other trades.
	 */
	List<? extends TradeIdentifier> getOriginatingTradeId();
	/**
	 * Deprecated: The USIs of the components of this trade, when this trade contains a strategy.
	 */
	List<? extends ProductComponentIdentifier> getProductComponentIdentifier();

	/*********************** Build Methods  ***********************/
	PartyTradeIdentifier build();
	
	PartyTradeIdentifier.PartyTradeIdentifierBuilder toBuilder();
	
	static PartyTradeIdentifier.PartyTradeIdentifierBuilder builder() {
		return new PartyTradeIdentifier.PartyTradeIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTradeIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyTradeIdentifier> getType() {
		return PartyTradeIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.class, getIssuerTradeIdModel());
		processRosetta(path.newSubPath("tradeIdentifierSequence"), processor, TradeIdentifierSequence.class, getTradeIdentifierSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("linkId"), processor, LinkId.class, getLinkId());
		processRosetta(path.newSubPath("allocationTradeId"), processor, TradeIdentifier.class, getAllocationTradeId());
		processRosetta(path.newSubPath("resultingTradeId"), processor, TradeIdentifierExtended.class, getResultingTradeId());
		processRosetta(path.newSubPath("blockTradeId"), processor, TradeIdentifier.class, getBlockTradeId());
		processRosetta(path.newSubPath("originatingTradeId"), processor, TradeIdentifier.class, getOriginatingTradeId());
		processRosetta(path.newSubPath("productComponentIdentifier"), processor, ProductComponentIdentifier.class, getProductComponentIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTradeIdentifierBuilder extends PartyTradeIdentifier, TradeIdentifier.TradeIdentifierBuilder {
		LinkId.LinkIdBuilder getOrCreateLinkId(int _index);
		List<? extends LinkId.LinkIdBuilder> getLinkId();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateAllocationTradeId(int _index);
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getAllocationTradeId();
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder getOrCreateResultingTradeId(int _index);
		List<? extends TradeIdentifierExtended.TradeIdentifierExtendedBuilder> getResultingTradeId();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeId();
		TradeIdentifier.TradeIdentifierBuilder getBlockTradeId();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateOriginatingTradeId(int _index);
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getOriginatingTradeId();
		ProductComponentIdentifier.ProductComponentIdentifierBuilder getOrCreateProductComponentIdentifier(int _index);
		List<? extends ProductComponentIdentifier.ProductComponentIdentifierBuilder> getProductComponentIdentifier();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setTradeIdentifierSequence(TradeIdentifierSequence tradeIdentifierSequence);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setId(String id);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(LinkId linkId0);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(LinkId linkId1, int _idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(List<? extends LinkId> linkId2);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setLinkId(List<? extends LinkId> linkId3);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(TradeIdentifier allocationTradeId0);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(TradeIdentifier allocationTradeId1, int _idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(List<? extends TradeIdentifier> allocationTradeId2);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setAllocationTradeId(List<? extends TradeIdentifier> allocationTradeId3);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(TradeIdentifierExtended resultingTradeId0);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(TradeIdentifierExtended resultingTradeId1, int _idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(List<? extends TradeIdentifierExtended> resultingTradeId2);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setResultingTradeId(List<? extends TradeIdentifierExtended> resultingTradeId3);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setBlockTradeId(TradeIdentifier blockTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(TradeIdentifier originatingTradeId0);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(TradeIdentifier originatingTradeId1, int _idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(List<? extends TradeIdentifier> originatingTradeId2);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setOriginatingTradeId(List<? extends TradeIdentifier> originatingTradeId3);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(ProductComponentIdentifier productComponentIdentifier0);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(ProductComponentIdentifier productComponentIdentifier1, int _idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(List<? extends ProductComponentIdentifier> productComponentIdentifier2);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setProductComponentIdentifier(List<? extends ProductComponentIdentifier> productComponentIdentifier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerTradeIdModel"), processor, IssuerTradeIdModel.IssuerTradeIdModelBuilder.class, getIssuerTradeIdModel());
			processRosetta(path.newSubPath("tradeIdentifierSequence"), processor, TradeIdentifierSequence.TradeIdentifierSequenceBuilder.class, getTradeIdentifierSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("linkId"), processor, LinkId.LinkIdBuilder.class, getLinkId());
			processRosetta(path.newSubPath("allocationTradeId"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getAllocationTradeId());
			processRosetta(path.newSubPath("resultingTradeId"), processor, TradeIdentifierExtended.TradeIdentifierExtendedBuilder.class, getResultingTradeId());
			processRosetta(path.newSubPath("blockTradeId"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getBlockTradeId());
			processRosetta(path.newSubPath("originatingTradeId"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getOriginatingTradeId());
			processRosetta(path.newSubPath("productComponentIdentifier"), processor, ProductComponentIdentifier.ProductComponentIdentifierBuilder.class, getProductComponentIdentifier());
		}
		

		PartyTradeIdentifier.PartyTradeIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTradeIdentifier  ***********************/
	class PartyTradeIdentifierImpl extends TradeIdentifier.TradeIdentifierImpl implements PartyTradeIdentifier {
		private final List<? extends LinkId> linkId;
		private final List<? extends TradeIdentifier> allocationTradeId;
		private final List<? extends TradeIdentifierExtended> resultingTradeId;
		private final TradeIdentifier blockTradeId;
		private final List<? extends TradeIdentifier> originatingTradeId;
		private final List<? extends ProductComponentIdentifier> productComponentIdentifier;
		
		protected PartyTradeIdentifierImpl(PartyTradeIdentifier.PartyTradeIdentifierBuilder builder) {
			super(builder);
			this.linkId = ofNullable(builder.getLinkId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.allocationTradeId = ofNullable(builder.getAllocationTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.resultingTradeId = ofNullable(builder.getResultingTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.blockTradeId = ofNullable(builder.getBlockTradeId()).map(f->f.build()).orElse(null);
			this.originatingTradeId = ofNullable(builder.getOriginatingTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productComponentIdentifier = ofNullable(builder.getProductComponentIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("linkId")
		public List<? extends LinkId> getLinkId() {
			return linkId;
		}
		
		@Override
		@RosettaAttribute("allocationTradeId")
		public List<? extends TradeIdentifier> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		@RosettaAttribute("resultingTradeId")
		public List<? extends TradeIdentifierExtended> getResultingTradeId() {
			return resultingTradeId;
		}
		
		@Override
		@RosettaAttribute("blockTradeId")
		public TradeIdentifier getBlockTradeId() {
			return blockTradeId;
		}
		
		@Override
		@RosettaAttribute("originatingTradeId")
		public List<? extends TradeIdentifier> getOriginatingTradeId() {
			return originatingTradeId;
		}
		
		@Override
		@RosettaAttribute("productComponentIdentifier")
		public List<? extends ProductComponentIdentifier> getProductComponentIdentifier() {
			return productComponentIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier build() {
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder toBuilder() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTradeIdentifier.PartyTradeIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLinkId()).ifPresent(builder::setLinkId);
			ofNullable(getAllocationTradeId()).ifPresent(builder::setAllocationTradeId);
			ofNullable(getResultingTradeId()).ifPresent(builder::setResultingTradeId);
			ofNullable(getBlockTradeId()).ifPresent(builder::setBlockTradeId);
			ofNullable(getOriginatingTradeId()).ifPresent(builder::setOriginatingTradeId);
			ofNullable(getProductComponentIdentifier()).ifPresent(builder::setProductComponentIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyTradeIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(linkId, _that.getLinkId())) return false;
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!ListEquals.listEquals(resultingTradeId, _that.getResultingTradeId())) return false;
			if (!Objects.equals(blockTradeId, _that.getBlockTradeId())) return false;
			if (!ListEquals.listEquals(originatingTradeId, _that.getOriginatingTradeId())) return false;
			if (!ListEquals.listEquals(productComponentIdentifier, _that.getProductComponentIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (linkId != null ? linkId.hashCode() : 0);
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (resultingTradeId != null ? resultingTradeId.hashCode() : 0);
			_result = 31 * _result + (blockTradeId != null ? blockTradeId.hashCode() : 0);
			_result = 31 * _result + (originatingTradeId != null ? originatingTradeId.hashCode() : 0);
			_result = 31 * _result + (productComponentIdentifier != null ? productComponentIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeIdentifier {" +
				"linkId=" + this.linkId + ", " +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"resultingTradeId=" + this.resultingTradeId + ", " +
				"blockTradeId=" + this.blockTradeId + ", " +
				"originatingTradeId=" + this.originatingTradeId + ", " +
				"productComponentIdentifier=" + this.productComponentIdentifier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PartyTradeIdentifier  ***********************/
	class PartyTradeIdentifierBuilderImpl extends TradeIdentifier.TradeIdentifierBuilderImpl  implements PartyTradeIdentifier.PartyTradeIdentifierBuilder {
	
		protected List<LinkId.LinkIdBuilder> linkId = new ArrayList<>();
		protected List<TradeIdentifier.TradeIdentifierBuilder> allocationTradeId = new ArrayList<>();
		protected List<TradeIdentifierExtended.TradeIdentifierExtendedBuilder> resultingTradeId = new ArrayList<>();
		protected TradeIdentifier.TradeIdentifierBuilder blockTradeId;
		protected List<TradeIdentifier.TradeIdentifierBuilder> originatingTradeId = new ArrayList<>();
		protected List<ProductComponentIdentifier.ProductComponentIdentifierBuilder> productComponentIdentifier = new ArrayList<>();
	
		public PartyTradeIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("linkId")
		public List<? extends LinkId.LinkIdBuilder> getLinkId() {
			return linkId;
		}
		
		@Override
		public LinkId.LinkIdBuilder getOrCreateLinkId(int _index) {
		
			if (linkId==null) {
				this.linkId = new ArrayList<>();
			}
			LinkId.LinkIdBuilder result;
			return getIndex(linkId, _index, () -> {
						LinkId.LinkIdBuilder newLinkId = LinkId.builder();
						return newLinkId;
					});
		}
		
		@Override
		@RosettaAttribute("allocationTradeId")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateAllocationTradeId(int _index) {
		
			if (allocationTradeId==null) {
				this.allocationTradeId = new ArrayList<>();
			}
			TradeIdentifier.TradeIdentifierBuilder result;
			return getIndex(allocationTradeId, _index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newAllocationTradeId = TradeIdentifier.builder();
						return newAllocationTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("resultingTradeId")
		public List<? extends TradeIdentifierExtended.TradeIdentifierExtendedBuilder> getResultingTradeId() {
			return resultingTradeId;
		}
		
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder getOrCreateResultingTradeId(int _index) {
		
			if (resultingTradeId==null) {
				this.resultingTradeId = new ArrayList<>();
			}
			TradeIdentifierExtended.TradeIdentifierExtendedBuilder result;
			return getIndex(resultingTradeId, _index, () -> {
						TradeIdentifierExtended.TradeIdentifierExtendedBuilder newResultingTradeId = TradeIdentifierExtended.builder();
						return newResultingTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("blockTradeId")
		public TradeIdentifier.TradeIdentifierBuilder getBlockTradeId() {
			return blockTradeId;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeId() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (blockTradeId!=null) {
				result = blockTradeId;
			}
			else {
				result = blockTradeId = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingTradeId")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getOriginatingTradeId() {
			return originatingTradeId;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateOriginatingTradeId(int _index) {
		
			if (originatingTradeId==null) {
				this.originatingTradeId = new ArrayList<>();
			}
			TradeIdentifier.TradeIdentifierBuilder result;
			return getIndex(originatingTradeId, _index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newOriginatingTradeId = TradeIdentifier.builder();
						return newOriginatingTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("productComponentIdentifier")
		public List<? extends ProductComponentIdentifier.ProductComponentIdentifierBuilder> getProductComponentIdentifier() {
			return productComponentIdentifier;
		}
		
		@Override
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder getOrCreateProductComponentIdentifier(int _index) {
		
			if (productComponentIdentifier==null) {
				this.productComponentIdentifier = new ArrayList<>();
			}
			ProductComponentIdentifier.ProductComponentIdentifierBuilder result;
			return getIndex(productComponentIdentifier, _index, () -> {
						ProductComponentIdentifier.ProductComponentIdentifierBuilder newProductComponentIdentifier = ProductComponentIdentifier.builder();
						return newProductComponentIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("issuerTradeIdModel")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setIssuerTradeIdModel(IssuerTradeIdModel issuerTradeIdModel) {
			this.issuerTradeIdModel = issuerTradeIdModel==null?null:issuerTradeIdModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdentifierSequence")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setTradeIdentifierSequence(TradeIdentifierSequence tradeIdentifierSequence) {
			this.tradeIdentifierSequence = tradeIdentifierSequence==null?null:tradeIdentifierSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("linkId")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(LinkId linkId) {
			if (linkId!=null) this.linkId.add(linkId.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(LinkId linkId, int _idx) {
			getIndex(this.linkId, _idx, () -> linkId.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(List<? extends LinkId> linkIds) {
			if (linkIds != null) {
				for (LinkId toAdd : linkIds) {
					this.linkId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setLinkId(List<? extends LinkId> linkIds) {
			if (linkIds == null)  {
				this.linkId = new ArrayList<>();
			}
			else {
				this.linkId = linkIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("allocationTradeId")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(TradeIdentifier allocationTradeId) {
			if (allocationTradeId!=null) this.allocationTradeId.add(allocationTradeId.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(TradeIdentifier allocationTradeId, int _idx) {
			getIndex(this.allocationTradeId, _idx, () -> allocationTradeId.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(List<? extends TradeIdentifier> allocationTradeIds) {
			if (allocationTradeIds != null) {
				for (TradeIdentifier toAdd : allocationTradeIds) {
					this.allocationTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setAllocationTradeId(List<? extends TradeIdentifier> allocationTradeIds) {
			if (allocationTradeIds == null)  {
				this.allocationTradeId = new ArrayList<>();
			}
			else {
				this.allocationTradeId = allocationTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("resultingTradeId")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(TradeIdentifierExtended resultingTradeId) {
			if (resultingTradeId!=null) this.resultingTradeId.add(resultingTradeId.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(TradeIdentifierExtended resultingTradeId, int _idx) {
			getIndex(this.resultingTradeId, _idx, () -> resultingTradeId.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(List<? extends TradeIdentifierExtended> resultingTradeIds) {
			if (resultingTradeIds != null) {
				for (TradeIdentifierExtended toAdd : resultingTradeIds) {
					this.resultingTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setResultingTradeId(List<? extends TradeIdentifierExtended> resultingTradeIds) {
			if (resultingTradeIds == null)  {
				this.resultingTradeId = new ArrayList<>();
			}
			else {
				this.resultingTradeId = resultingTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("blockTradeId")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setBlockTradeId(TradeIdentifier blockTradeId) {
			this.blockTradeId = blockTradeId==null?null:blockTradeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originatingTradeId")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(TradeIdentifier originatingTradeId) {
			if (originatingTradeId!=null) this.originatingTradeId.add(originatingTradeId.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(TradeIdentifier originatingTradeId, int _idx) {
			getIndex(this.originatingTradeId, _idx, () -> originatingTradeId.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(List<? extends TradeIdentifier> originatingTradeIds) {
			if (originatingTradeIds != null) {
				for (TradeIdentifier toAdd : originatingTradeIds) {
					this.originatingTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setOriginatingTradeId(List<? extends TradeIdentifier> originatingTradeIds) {
			if (originatingTradeIds == null)  {
				this.originatingTradeId = new ArrayList<>();
			}
			else {
				this.originatingTradeId = originatingTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("productComponentIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(ProductComponentIdentifier productComponentIdentifier) {
			if (productComponentIdentifier!=null) this.productComponentIdentifier.add(productComponentIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(ProductComponentIdentifier productComponentIdentifier, int _idx) {
			getIndex(this.productComponentIdentifier, _idx, () -> productComponentIdentifier.toBuilder());
			return this;
		}
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(List<? extends ProductComponentIdentifier> productComponentIdentifiers) {
			if (productComponentIdentifiers != null) {
				for (ProductComponentIdentifier toAdd : productComponentIdentifiers) {
					this.productComponentIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setProductComponentIdentifier(List<? extends ProductComponentIdentifier> productComponentIdentifiers) {
			if (productComponentIdentifiers == null)  {
				this.productComponentIdentifier = new ArrayList<>();
			}
			else {
				this.productComponentIdentifier = productComponentIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PartyTradeIdentifier build() {
			return new PartyTradeIdentifier.PartyTradeIdentifierImpl(this);
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder prune() {
			super.prune();
			linkId = linkId.stream().filter(b->b!=null).<LinkId.LinkIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			allocationTradeId = allocationTradeId.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			resultingTradeId = resultingTradeId.stream().filter(b->b!=null).<TradeIdentifierExtended.TradeIdentifierExtendedBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (blockTradeId!=null && !blockTradeId.prune().hasData()) blockTradeId = null;
			originatingTradeId = originatingTradeId.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productComponentIdentifier = productComponentIdentifier.stream().filter(b->b!=null).<ProductComponentIdentifier.ProductComponentIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLinkId()!=null && getLinkId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAllocationTradeId()!=null && getAllocationTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getResultingTradeId()!=null && getResultingTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBlockTradeId()!=null && getBlockTradeId().hasData()) return true;
			if (getOriginatingTradeId()!=null && getOriginatingTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductComponentIdentifier()!=null && getProductComponentIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PartyTradeIdentifier.PartyTradeIdentifierBuilder o = (PartyTradeIdentifier.PartyTradeIdentifierBuilder) other;
			
			merger.mergeRosetta(getLinkId(), o.getLinkId(), this::getOrCreateLinkId);
			merger.mergeRosetta(getAllocationTradeId(), o.getAllocationTradeId(), this::getOrCreateAllocationTradeId);
			merger.mergeRosetta(getResultingTradeId(), o.getResultingTradeId(), this::getOrCreateResultingTradeId);
			merger.mergeRosetta(getBlockTradeId(), o.getBlockTradeId(), this::setBlockTradeId);
			merger.mergeRosetta(getOriginatingTradeId(), o.getOriginatingTradeId(), this::getOrCreateOriginatingTradeId);
			merger.mergeRosetta(getProductComponentIdentifier(), o.getProductComponentIdentifier(), this::getOrCreateProductComponentIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyTradeIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(linkId, _that.getLinkId())) return false;
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!ListEquals.listEquals(resultingTradeId, _that.getResultingTradeId())) return false;
			if (!Objects.equals(blockTradeId, _that.getBlockTradeId())) return false;
			if (!ListEquals.listEquals(originatingTradeId, _that.getOriginatingTradeId())) return false;
			if (!ListEquals.listEquals(productComponentIdentifier, _that.getProductComponentIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (linkId != null ? linkId.hashCode() : 0);
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (resultingTradeId != null ? resultingTradeId.hashCode() : 0);
			_result = 31 * _result + (blockTradeId != null ? blockTradeId.hashCode() : 0);
			_result = 31 * _result + (originatingTradeId != null ? originatingTradeId.hashCode() : 0);
			_result = 31 * _result + (productComponentIdentifier != null ? productComponentIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeIdentifierBuilder {" +
				"linkId=" + this.linkId + ", " +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"resultingTradeId=" + this.resultingTradeId + ", " +
				"blockTradeId=" + this.blockTradeId + ", " +
				"originatingTradeId=" + this.originatingTradeId + ", " +
				"productComponentIdentifier=" + this.productComponentIdentifier +
			'}' + " " + super.toString();
		}
	}
}
