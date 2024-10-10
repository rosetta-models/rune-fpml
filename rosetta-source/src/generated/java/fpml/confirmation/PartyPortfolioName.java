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
import fpml.confirmation.PartyPortfolioName.PartyPortfolioNameBuilder;
import fpml.confirmation.PartyPortfolioName.PartyPortfolioNameBuilderImpl;
import fpml.confirmation.PartyPortfolioName.PartyPortfolioNameImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PortfolioName;
import fpml.confirmation.meta.PartyPortfolioNameMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type to represent a portfolio name for a particular party.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyPortfolioName", builder=PartyPortfolioName.PartyPortfolioNameBuilderImpl.class, version="${project.version}")
public interface PartyPortfolioName extends RosettaModelObject {

	PartyPortfolioNameMeta metaData = new PartyPortfolioNameMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to a party identifier defined elsewhere in the document. The party referenced has allocated the trade identifier.
	 */
	PartyReference getPartyReference();
	List<? extends PortfolioName> getPortfolioName();
	String getId();

	/*********************** Build Methods  ***********************/
	PartyPortfolioName build();
	
	PartyPortfolioName.PartyPortfolioNameBuilder toBuilder();
	
	static PartyPortfolioName.PartyPortfolioNameBuilder builder() {
		return new PartyPortfolioName.PartyPortfolioNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyPortfolioName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyPortfolioName> getType() {
		return PartyPortfolioName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.class, getPortfolioName());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyPortfolioNameBuilder extends PartyPortfolioName, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		PortfolioName.PortfolioNameBuilder getOrCreatePortfolioName(int _index);
		List<? extends PortfolioName.PortfolioNameBuilder> getPortfolioName();
		PartyPortfolioName.PartyPortfolioNameBuilder setPartyReference(PartyReference partyReference);
		PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(PortfolioName portfolioName0);
		PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(PortfolioName portfolioName1, int _idx);
		PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(List<? extends PortfolioName> portfolioName2);
		PartyPortfolioName.PartyPortfolioNameBuilder setPortfolioName(List<? extends PortfolioName> portfolioName3);
		PartyPortfolioName.PartyPortfolioNameBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.PortfolioNameBuilder.class, getPortfolioName());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PartyPortfolioName.PartyPortfolioNameBuilder prune();
	}

	/*********************** Immutable Implementation of PartyPortfolioName  ***********************/
	class PartyPortfolioNameImpl implements PartyPortfolioName {
		private final PartyReference partyReference;
		private final List<? extends PortfolioName> portfolioName;
		private final String id;
		
		protected PartyPortfolioNameImpl(PartyPortfolioName.PartyPortfolioNameBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.portfolioName = ofNullable(builder.getPortfolioName()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("portfolioName")
		public List<? extends PortfolioName> getPortfolioName() {
			return portfolioName;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PartyPortfolioName build() {
			return this;
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder toBuilder() {
			PartyPortfolioName.PartyPortfolioNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyPortfolioName.PartyPortfolioNameBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getPortfolioName()).ifPresent(builder::setPortfolioName);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyPortfolioName _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(portfolioName, _that.getPortfolioName())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (portfolioName != null ? portfolioName.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyPortfolioName {" +
				"partyReference=" + this.partyReference + ", " +
				"portfolioName=" + this.portfolioName + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyPortfolioName  ***********************/
	class PartyPortfolioNameBuilderImpl implements PartyPortfolioName.PartyPortfolioNameBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<PortfolioName.PortfolioNameBuilder> portfolioName = new ArrayList<>();
		protected String id;
	
		public PartyPortfolioNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioName")
		public List<? extends PortfolioName.PortfolioNameBuilder> getPortfolioName() {
			return portfolioName;
		}
		
		public PortfolioName.PortfolioNameBuilder getOrCreatePortfolioName(int _index) {
		
			if (portfolioName==null) {
				this.portfolioName = new ArrayList<>();
			}
			PortfolioName.PortfolioNameBuilder result;
			return getIndex(portfolioName, _index, () -> {
						PortfolioName.PortfolioNameBuilder newPortfolioName = PortfolioName.builder();
						return newPortfolioName;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyPortfolioName.PartyPortfolioNameBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(PortfolioName portfolioName) {
			if (portfolioName!=null) this.portfolioName.add(portfolioName.toBuilder());
			return this;
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(PortfolioName portfolioName, int _idx) {
			getIndex(this.portfolioName, _idx, () -> portfolioName.toBuilder());
			return this;
		}
		@Override 
		public PartyPortfolioName.PartyPortfolioNameBuilder addPortfolioName(List<? extends PortfolioName> portfolioNames) {
			if (portfolioNames != null) {
				for (PortfolioName toAdd : portfolioNames) {
					this.portfolioName.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("portfolioName")
		public PartyPortfolioName.PartyPortfolioNameBuilder setPortfolioName(List<? extends PortfolioName> portfolioNames) {
			if (portfolioNames == null)  {
				this.portfolioName = new ArrayList<>();
			}
			else {
				this.portfolioName = portfolioNames.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public PartyPortfolioName.PartyPortfolioNameBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PartyPortfolioName build() {
			return new PartyPortfolioName.PartyPortfolioNameImpl(this);
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			portfolioName = portfolioName.stream().filter(b->b!=null).<PortfolioName.PortfolioNameBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getPortfolioName()!=null && getPortfolioName().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyPortfolioName.PartyPortfolioNameBuilder o = (PartyPortfolioName.PartyPortfolioNameBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getPortfolioName(), o.getPortfolioName(), this::getOrCreatePortfolioName);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyPortfolioName _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(portfolioName, _that.getPortfolioName())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (portfolioName != null ? portfolioName.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyPortfolioNameBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"portfolioName=" + this.portfolioName + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
