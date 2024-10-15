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
import fpml.confirmation.Allocations;
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.RequestAllocation;
import fpml.confirmation.RequestAllocation.RequestAllocationBuilder;
import fpml.confirmation.RequestAllocation.RequestAllocationBuilderImpl;
import fpml.confirmation.RequestAllocation.RequestAllocationImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestAllocationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message requesting that a trade be split among several accounts.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestAllocation", builder=RequestAllocation.RequestAllocationBuilderImpl.class, version="${project.version}")
public interface RequestAllocation extends CorrectableRequestMessage {

	RequestAllocationMeta metaData = new RequestAllocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies a related party performing a role within the transaction.
	 */
	List<? extends RelatedParty> getRelatedParty();
	TradeIdentifier getBlockTradeIdentifier();
	Allocations getAllocations();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestAllocation build();
	
	RequestAllocation.RequestAllocationBuilder toBuilder();
	
	static RequestAllocation.RequestAllocationBuilder builder() {
		return new RequestAllocation.RequestAllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestAllocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestAllocation> getType() {
		return RequestAllocation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("blockTradeIdentifier"), processor, TradeIdentifier.class, getBlockTradeIdentifier());
		processRosetta(path.newSubPath("allocations"), processor, Allocations.class, getAllocations());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestAllocationBuilder extends RequestAllocation, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index);
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getBlockTradeIdentifier();
		Allocations.AllocationsBuilder getOrCreateAllocations();
		Allocations.AllocationsBuilder getAllocations();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestAllocation.RequestAllocationBuilder setExpectedBuild(Integer expectedBuild);
		RequestAllocation.RequestAllocationBuilder setActualBuild(Integer actualBuild);
		RequestAllocation.RequestAllocationBuilder setHeader(RequestMessageHeader header);
		RequestAllocation.RequestAllocationBuilder setValidationModel(ValidationModel validationModel);
		RequestAllocation.RequestAllocationBuilder setIsCorrection(Boolean isCorrection);
		RequestAllocation.RequestAllocationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestAllocation.RequestAllocationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestAllocation.RequestAllocationBuilder addRelatedParty(RelatedParty relatedParty0);
		RequestAllocation.RequestAllocationBuilder addRelatedParty(RelatedParty relatedParty1, int _idx);
		RequestAllocation.RequestAllocationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty2);
		RequestAllocation.RequestAllocationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty3);
		RequestAllocation.RequestAllocationBuilder setBlockTradeIdentifier(TradeIdentifier blockTradeIdentifier);
		RequestAllocation.RequestAllocationBuilder setAllocations(Allocations allocations);
		RequestAllocation.RequestAllocationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("blockTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getBlockTradeIdentifier());
			processRosetta(path.newSubPath("allocations"), processor, Allocations.AllocationsBuilder.class, getAllocations());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestAllocation.RequestAllocationBuilder prune();
	}

	/*********************** Immutable Implementation of RequestAllocation  ***********************/
	class RequestAllocationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestAllocation {
		private final List<? extends RelatedParty> relatedParty;
		private final TradeIdentifier blockTradeIdentifier;
		private final Allocations allocations;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestAllocationImpl(RequestAllocation.RequestAllocationBuilder builder) {
			super(builder);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.blockTradeIdentifier = ofNullable(builder.getBlockTradeIdentifier()).map(f->f.build()).orElse(null);
			this.allocations = ofNullable(builder.getAllocations()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		public TradeIdentifier getBlockTradeIdentifier() {
			return blockTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("allocations")
		public Allocations getAllocations() {
			return allocations;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestAllocation build() {
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder toBuilder() {
			RequestAllocation.RequestAllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestAllocation.RequestAllocationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getBlockTradeIdentifier()).ifPresent(builder::setBlockTradeIdentifier);
			ofNullable(getAllocations()).ifPresent(builder::setAllocations);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestAllocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestAllocation {" +
				"relatedParty=" + this.relatedParty + ", " +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestAllocation  ***********************/
	class RequestAllocationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements RequestAllocation.RequestAllocationBuilder {
	
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected TradeIdentifier.TradeIdentifierBuilder blockTradeIdentifier;
		protected Allocations.AllocationsBuilder allocations;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestAllocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index) {
		
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			RelatedParty.RelatedPartyBuilder result;
			return getIndex(relatedParty, _index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getBlockTradeIdentifier() {
			return blockTradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (blockTradeIdentifier!=null) {
				result = blockTradeIdentifier;
			}
			else {
				result = blockTradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocations")
		public Allocations.AllocationsBuilder getAllocations() {
			return allocations;
		}
		
		@Override
		public Allocations.AllocationsBuilder getOrCreateAllocations() {
			Allocations.AllocationsBuilder result;
			if (allocations!=null) {
				result = allocations;
			}
			else {
				result = allocations = Allocations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel() {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder result;
			if (partiesAndAccountsModel!=null) {
				result = partiesAndAccountsModel;
			}
			else {
				result = partiesAndAccountsModel = PartiesAndAccountsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public RequestAllocation.RequestAllocationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestAllocation.RequestAllocationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestAllocation.RequestAllocationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestAllocation.RequestAllocationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RequestAllocation.RequestAllocationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestAllocation.RequestAllocationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestAllocation.RequestAllocationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		public RequestAllocation.RequestAllocationBuilder addRelatedParty(RelatedParty relatedParty) {
			if (relatedParty!=null) this.relatedParty.add(relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addRelatedParty(RelatedParty relatedParty, int _idx) {
			getIndex(this.relatedParty, _idx, () -> relatedParty.toBuilder());
			return this;
		}
		@Override 
		public RequestAllocation.RequestAllocationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("relatedParty")
		public RequestAllocation.RequestAllocationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null)  {
				this.relatedParty = new ArrayList<>();
			}
			else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		public RequestAllocation.RequestAllocationBuilder setBlockTradeIdentifier(TradeIdentifier blockTradeIdentifier) {
			this.blockTradeIdentifier = blockTradeIdentifier==null?null:blockTradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocations")
		public RequestAllocation.RequestAllocationBuilder setAllocations(Allocations allocations) {
			this.allocations = allocations==null?null:allocations.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestAllocation.RequestAllocationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestAllocation build() {
			return new RequestAllocation.RequestAllocationImpl(this);
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestAllocation.RequestAllocationBuilder prune() {
			super.prune();
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (blockTradeIdentifier!=null && !blockTradeIdentifier.prune().hasData()) blockTradeIdentifier = null;
			if (allocations!=null && !allocations.prune().hasData()) allocations = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBlockTradeIdentifier()!=null && getBlockTradeIdentifier().hasData()) return true;
			if (getAllocations()!=null && getAllocations().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestAllocation.RequestAllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestAllocation.RequestAllocationBuilder o = (RequestAllocation.RequestAllocationBuilder) other;
			
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getBlockTradeIdentifier(), o.getBlockTradeIdentifier(), this::setBlockTradeIdentifier);
			merger.mergeRosetta(getAllocations(), o.getAllocations(), this::setAllocations);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestAllocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestAllocationBuilder {" +
				"relatedParty=" + this.relatedParty + ", " +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
