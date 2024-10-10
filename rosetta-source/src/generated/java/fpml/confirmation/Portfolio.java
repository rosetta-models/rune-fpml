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
import fpml.confirmation.PartyPortfolioName;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Portfolio;
import fpml.confirmation.Portfolio.PortfolioBuilder;
import fpml.confirmation.Portfolio.PortfolioBuilderImpl;
import fpml.confirmation.Portfolio.PortfolioImpl;
import fpml.confirmation.TradeId;
import fpml.confirmation.meta.PortfolioMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type representing an arbitary grouping of trade references.
 * @version ${project.version}
 */
@RosettaDataType(value="Portfolio", builder=Portfolio.PortfolioBuilderImpl.class, version="${project.version}")
public interface Portfolio extends RosettaModelObject {

	PortfolioMeta metaData = new PortfolioMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the portfolio together with the party that gave the name.
	 */
	PartyPortfolioName getPartyPortfolioName();
	List<? extends TradeId> getTradeId();
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 * An arbitary grouping of trade references (and possibly other portfolios).
	 */
	List<? extends Portfolio> getPortfolio();
	String getId();

	/*********************** Build Methods  ***********************/
	Portfolio build();
	
	Portfolio.PortfolioBuilder toBuilder();
	
	static Portfolio.PortfolioBuilder builder() {
		return new Portfolio.PortfolioBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Portfolio> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Portfolio> getType() {
		return Portfolio.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyPortfolioName"), processor, PartyPortfolioName.class, getPartyPortfolioName());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("portfolio"), processor, Portfolio.class, getPortfolio());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioBuilder extends Portfolio, RosettaModelObjectBuilder {
		PartyPortfolioName.PartyPortfolioNameBuilder getOrCreatePartyPortfolioName();
		PartyPortfolioName.PartyPortfolioNameBuilder getPartyPortfolioName();
		TradeId.TradeIdBuilder getOrCreateTradeId(int _index);
		List<? extends TradeId.TradeIdBuilder> getTradeId();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		Portfolio.PortfolioBuilder getOrCreatePortfolio(int _index);
		List<? extends Portfolio.PortfolioBuilder> getPortfolio();
		Portfolio.PortfolioBuilder setPartyPortfolioName(PartyPortfolioName partyPortfolioName);
		Portfolio.PortfolioBuilder addTradeId(TradeId tradeId0);
		Portfolio.PortfolioBuilder addTradeId(TradeId tradeId1, int _idx);
		Portfolio.PortfolioBuilder addTradeId(List<? extends TradeId> tradeId2);
		Portfolio.PortfolioBuilder setTradeId(List<? extends TradeId> tradeId3);
		Portfolio.PortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier0);
		Portfolio.PortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier1, int _idx);
		Portfolio.PortfolioBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier2);
		Portfolio.PortfolioBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier3);
		Portfolio.PortfolioBuilder addPortfolio(Portfolio portfolio0);
		Portfolio.PortfolioBuilder addPortfolio(Portfolio portfolio1, int _idx);
		Portfolio.PortfolioBuilder addPortfolio(List<? extends Portfolio> portfolio2);
		Portfolio.PortfolioBuilder setPortfolio(List<? extends Portfolio> portfolio3);
		Portfolio.PortfolioBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyPortfolioName"), processor, PartyPortfolioName.PartyPortfolioNameBuilder.class, getPartyPortfolioName());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("portfolio"), processor, Portfolio.PortfolioBuilder.class, getPortfolio());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Portfolio.PortfolioBuilder prune();
	}

	/*********************** Immutable Implementation of Portfolio  ***********************/
	class PortfolioImpl implements Portfolio {
		private final PartyPortfolioName partyPortfolioName;
		private final List<? extends TradeId> tradeId;
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends Portfolio> portfolio;
		private final String id;
		
		protected PortfolioImpl(Portfolio.PortfolioBuilder builder) {
			this.partyPortfolioName = ofNullable(builder.getPartyPortfolioName()).map(f->f.build()).orElse(null);
			this.tradeId = ofNullable(builder.getTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.portfolio = ofNullable(builder.getPortfolio()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyPortfolioName")
		public PartyPortfolioName getPartyPortfolioName() {
			return partyPortfolioName;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public List<? extends TradeId> getTradeId() {
			return tradeId;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("portfolio")
		public List<? extends Portfolio> getPortfolio() {
			return portfolio;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Portfolio build() {
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder toBuilder() {
			Portfolio.PortfolioBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Portfolio.PortfolioBuilder builder) {
			ofNullable(getPartyPortfolioName()).ifPresent(builder::setPartyPortfolioName);
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPortfolio()).ifPresent(builder::setPortfolio);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Portfolio _that = getType().cast(o);
		
			if (!Objects.equals(partyPortfolioName, _that.getPartyPortfolioName())) return false;
			if (!ListEquals.listEquals(tradeId, _that.getTradeId())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(portfolio, _that.getPortfolio())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyPortfolioName != null ? partyPortfolioName.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Portfolio {" +
				"partyPortfolioName=" + this.partyPortfolioName + ", " +
				"tradeId=" + this.tradeId + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"portfolio=" + this.portfolio + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Portfolio  ***********************/
	class PortfolioBuilderImpl implements Portfolio.PortfolioBuilder {
	
		protected PartyPortfolioName.PartyPortfolioNameBuilder partyPortfolioName;
		protected List<TradeId.TradeIdBuilder> tradeId = new ArrayList<>();
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<Portfolio.PortfolioBuilder> portfolio = new ArrayList<>();
		protected String id;
	
		public PortfolioBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyPortfolioName")
		public PartyPortfolioName.PartyPortfolioNameBuilder getPartyPortfolioName() {
			return partyPortfolioName;
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder getOrCreatePartyPortfolioName() {
			PartyPortfolioName.PartyPortfolioNameBuilder result;
			if (partyPortfolioName!=null) {
				result = partyPortfolioName;
			}
			else {
				result = partyPortfolioName = PartyPortfolioName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public List<? extends TradeId.TradeIdBuilder> getTradeId() {
			return tradeId;
		}
		
		public TradeId.TradeIdBuilder getOrCreateTradeId(int _index) {
		
			if (tradeId==null) {
				this.tradeId = new ArrayList<>();
			}
			TradeId.TradeIdBuilder result;
			return getIndex(tradeId, _index, () -> {
						TradeId.TradeIdBuilder newTradeId = TradeId.builder();
						return newTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int _index) {
		
			if (partyTradeIdentifier==null) {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(partyTradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newPartyTradeIdentifier = PartyTradeIdentifier.builder();
						return newPartyTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("portfolio")
		public List<? extends Portfolio.PortfolioBuilder> getPortfolio() {
			return portfolio;
		}
		
		public Portfolio.PortfolioBuilder getOrCreatePortfolio(int _index) {
		
			if (portfolio==null) {
				this.portfolio = new ArrayList<>();
			}
			Portfolio.PortfolioBuilder result;
			return getIndex(portfolio, _index, () -> {
						Portfolio.PortfolioBuilder newPortfolio = Portfolio.builder();
						return newPortfolio;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyPortfolioName")
		public Portfolio.PortfolioBuilder setPartyPortfolioName(PartyPortfolioName partyPortfolioName) {
			this.partyPortfolioName = partyPortfolioName==null?null:partyPortfolioName.toBuilder();
			return this;
		}
		@Override
		public Portfolio.PortfolioBuilder addTradeId(TradeId tradeId) {
			if (tradeId!=null) this.tradeId.add(tradeId.toBuilder());
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addTradeId(TradeId tradeId, int _idx) {
			getIndex(this.tradeId, _idx, () -> tradeId.toBuilder());
			return this;
		}
		@Override 
		public Portfolio.PortfolioBuilder addTradeId(List<? extends TradeId> tradeIds) {
			if (tradeIds != null) {
				for (TradeId toAdd : tradeIds) {
					this.tradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("tradeId")
		public Portfolio.PortfolioBuilder setTradeId(List<? extends TradeId> tradeIds) {
			if (tradeIds == null)  {
				this.tradeId = new ArrayList<>();
			}
			else {
				this.tradeId = tradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier) {
			if (partyTradeIdentifier!=null) this.partyTradeIdentifier.add(partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int _idx) {
			getIndex(this.partyTradeIdentifier, _idx, () -> partyTradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public Portfolio.PortfolioBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyTradeIdentifier")
		public Portfolio.PortfolioBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers == null)  {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			else {
				this.partyTradeIdentifier = partyTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addPortfolio(Portfolio portfolio) {
			if (portfolio!=null) this.portfolio.add(portfolio.toBuilder());
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addPortfolio(Portfolio portfolio, int _idx) {
			getIndex(this.portfolio, _idx, () -> portfolio.toBuilder());
			return this;
		}
		@Override 
		public Portfolio.PortfolioBuilder addPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios != null) {
				for (Portfolio toAdd : portfolios) {
					this.portfolio.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("portfolio")
		public Portfolio.PortfolioBuilder setPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios == null)  {
				this.portfolio = new ArrayList<>();
			}
			else {
				this.portfolio = portfolios.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public Portfolio.PortfolioBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Portfolio build() {
			return new Portfolio.PortfolioImpl(this);
		}
		
		@Override
		public Portfolio.PortfolioBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Portfolio.PortfolioBuilder prune() {
			if (partyPortfolioName!=null && !partyPortfolioName.prune().hasData()) partyPortfolioName = null;
			tradeId = tradeId.stream().filter(b->b!=null).<TradeId.TradeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			portfolio = portfolio.stream().filter(b->b!=null).<Portfolio.PortfolioBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyPortfolioName()!=null && getPartyPortfolioName().hasData()) return true;
			if (getTradeId()!=null && getTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPortfolio()!=null && getPortfolio().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Portfolio.PortfolioBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Portfolio.PortfolioBuilder o = (Portfolio.PortfolioBuilder) other;
			
			merger.mergeRosetta(getPartyPortfolioName(), o.getPartyPortfolioName(), this::setPartyPortfolioName);
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::getOrCreateTradeId);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPortfolio(), o.getPortfolio(), this::getOrCreatePortfolio);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Portfolio _that = getType().cast(o);
		
			if (!Objects.equals(partyPortfolioName, _that.getPartyPortfolioName())) return false;
			if (!ListEquals.listEquals(tradeId, _that.getTradeId())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(portfolio, _that.getPortfolio())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyPortfolioName != null ? partyPortfolioName.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioBuilder {" +
				"partyPortfolioName=" + this.partyPortfolioName + ", " +
				"tradeId=" + this.tradeId + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"portfolio=" + this.portfolio + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
