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
import fpml.confirmation.CollateralProfile;
import fpml.confirmation.CollateralType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TriParty;
import fpml.confirmation.TriParty.TriPartyBuilder;
import fpml.confirmation.TriParty.TriPartyBuilderImpl;
import fpml.confirmation.TriParty.TriPartyImpl;
import fpml.confirmation.meta.TriPartyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The tri-party terms.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TriParty", builder=TriParty.TriPartyBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TriParty extends RosettaModelObject {

	TriPartyMeta metaData = new TriPartyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reference to the tri-party agent.
	 */
	PartyReference getTriPartyAgent();
	/**
	 * The collateral profile specified at the tri-party agent.
	 */
	CollateralProfile getCollateralProfile();
	/**
	 * The collateral type, which is a restriction of the collateral deemed acceptable for the purpose of the transaction.
	 */
	CollateralType getCollateralType();

	/*********************** Build Methods  ***********************/
	TriParty build();
	
	TriParty.TriPartyBuilder toBuilder();
	
	static TriParty.TriPartyBuilder builder() {
		return new TriParty.TriPartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TriParty> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TriParty> getType() {
		return TriParty.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("triPartyAgent"), processor, PartyReference.class, getTriPartyAgent());
		processRosetta(path.newSubPath("collateralProfile"), processor, CollateralProfile.class, getCollateralProfile());
		processRosetta(path.newSubPath("collateralType"), processor, CollateralType.class, getCollateralType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriPartyBuilder extends TriParty, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateTriPartyAgent();
		PartyReference.PartyReferenceBuilder getTriPartyAgent();
		CollateralProfile.CollateralProfileBuilder getOrCreateCollateralProfile();
		CollateralProfile.CollateralProfileBuilder getCollateralProfile();
		CollateralType.CollateralTypeBuilder getOrCreateCollateralType();
		CollateralType.CollateralTypeBuilder getCollateralType();
		TriParty.TriPartyBuilder setTriPartyAgent(PartyReference triPartyAgent);
		TriParty.TriPartyBuilder setCollateralProfile(CollateralProfile collateralProfile);
		TriParty.TriPartyBuilder setCollateralType(CollateralType collateralType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("triPartyAgent"), processor, PartyReference.PartyReferenceBuilder.class, getTriPartyAgent());
			processRosetta(path.newSubPath("collateralProfile"), processor, CollateralProfile.CollateralProfileBuilder.class, getCollateralProfile());
			processRosetta(path.newSubPath("collateralType"), processor, CollateralType.CollateralTypeBuilder.class, getCollateralType());
		}
		

		TriParty.TriPartyBuilder prune();
	}

	/*********************** Immutable Implementation of TriParty  ***********************/
	class TriPartyImpl implements TriParty {
		private final PartyReference triPartyAgent;
		private final CollateralProfile collateralProfile;
		private final CollateralType collateralType;
		
		protected TriPartyImpl(TriParty.TriPartyBuilder builder) {
			this.triPartyAgent = ofNullable(builder.getTriPartyAgent()).map(f->f.build()).orElse(null);
			this.collateralProfile = ofNullable(builder.getCollateralProfile()).map(f->f.build()).orElse(null);
			this.collateralType = ofNullable(builder.getCollateralType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("triPartyAgent")
		public PartyReference getTriPartyAgent() {
			return triPartyAgent;
		}
		
		@Override
		@RosettaAttribute("collateralProfile")
		public CollateralProfile getCollateralProfile() {
			return collateralProfile;
		}
		
		@Override
		@RosettaAttribute("collateralType")
		public CollateralType getCollateralType() {
			return collateralType;
		}
		
		@Override
		public TriParty build() {
			return this;
		}
		
		@Override
		public TriParty.TriPartyBuilder toBuilder() {
			TriParty.TriPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TriParty.TriPartyBuilder builder) {
			ofNullable(getTriPartyAgent()).ifPresent(builder::setTriPartyAgent);
			ofNullable(getCollateralProfile()).ifPresent(builder::setCollateralProfile);
			ofNullable(getCollateralType()).ifPresent(builder::setCollateralType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriParty _that = getType().cast(o);
		
			if (!Objects.equals(triPartyAgent, _that.getTriPartyAgent())) return false;
			if (!Objects.equals(collateralProfile, _that.getCollateralProfile())) return false;
			if (!Objects.equals(collateralType, _that.getCollateralType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triPartyAgent != null ? triPartyAgent.hashCode() : 0);
			_result = 31 * _result + (collateralProfile != null ? collateralProfile.hashCode() : 0);
			_result = 31 * _result + (collateralType != null ? collateralType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriParty {" +
				"triPartyAgent=" + this.triPartyAgent + ", " +
				"collateralProfile=" + this.collateralProfile + ", " +
				"collateralType=" + this.collateralType +
			'}';
		}
	}

	/*********************** Builder Implementation of TriParty  ***********************/
	class TriPartyBuilderImpl implements TriParty.TriPartyBuilder {
	
		protected PartyReference.PartyReferenceBuilder triPartyAgent;
		protected CollateralProfile.CollateralProfileBuilder collateralProfile;
		protected CollateralType.CollateralTypeBuilder collateralType;
	
		public TriPartyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("triPartyAgent")
		public PartyReference.PartyReferenceBuilder getTriPartyAgent() {
			return triPartyAgent;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateTriPartyAgent() {
			PartyReference.PartyReferenceBuilder result;
			if (triPartyAgent!=null) {
				result = triPartyAgent;
			}
			else {
				result = triPartyAgent = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralProfile")
		public CollateralProfile.CollateralProfileBuilder getCollateralProfile() {
			return collateralProfile;
		}
		
		@Override
		public CollateralProfile.CollateralProfileBuilder getOrCreateCollateralProfile() {
			CollateralProfile.CollateralProfileBuilder result;
			if (collateralProfile!=null) {
				result = collateralProfile;
			}
			else {
				result = collateralProfile = CollateralProfile.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralType")
		public CollateralType.CollateralTypeBuilder getCollateralType() {
			return collateralType;
		}
		
		@Override
		public CollateralType.CollateralTypeBuilder getOrCreateCollateralType() {
			CollateralType.CollateralTypeBuilder result;
			if (collateralType!=null) {
				result = collateralType;
			}
			else {
				result = collateralType = CollateralType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triPartyAgent")
		public TriParty.TriPartyBuilder setTriPartyAgent(PartyReference triPartyAgent) {
			this.triPartyAgent = triPartyAgent==null?null:triPartyAgent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("collateralProfile")
		public TriParty.TriPartyBuilder setCollateralProfile(CollateralProfile collateralProfile) {
			this.collateralProfile = collateralProfile==null?null:collateralProfile.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("collateralType")
		public TriParty.TriPartyBuilder setCollateralType(CollateralType collateralType) {
			this.collateralType = collateralType==null?null:collateralType.toBuilder();
			return this;
		}
		
		@Override
		public TriParty build() {
			return new TriParty.TriPartyImpl(this);
		}
		
		@Override
		public TriParty.TriPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriParty.TriPartyBuilder prune() {
			if (triPartyAgent!=null && !triPartyAgent.prune().hasData()) triPartyAgent = null;
			if (collateralProfile!=null && !collateralProfile.prune().hasData()) collateralProfile = null;
			if (collateralType!=null && !collateralType.prune().hasData()) collateralType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriPartyAgent()!=null && getTriPartyAgent().hasData()) return true;
			if (getCollateralProfile()!=null && getCollateralProfile().hasData()) return true;
			if (getCollateralType()!=null && getCollateralType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriParty.TriPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TriParty.TriPartyBuilder o = (TriParty.TriPartyBuilder) other;
			
			merger.mergeRosetta(getTriPartyAgent(), o.getTriPartyAgent(), this::setTriPartyAgent);
			merger.mergeRosetta(getCollateralProfile(), o.getCollateralProfile(), this::setCollateralProfile);
			merger.mergeRosetta(getCollateralType(), o.getCollateralType(), this::setCollateralType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriParty _that = getType().cast(o);
		
			if (!Objects.equals(triPartyAgent, _that.getTriPartyAgent())) return false;
			if (!Objects.equals(collateralProfile, _that.getCollateralProfile())) return false;
			if (!Objects.equals(collateralType, _that.getCollateralType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triPartyAgent != null ? triPartyAgent.hashCode() : 0);
			_result = 31 * _result + (collateralProfile != null ? collateralProfile.hashCode() : 0);
			_result = 31 * _result + (collateralType != null ? collateralType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriPartyBuilder {" +
				"triPartyAgent=" + this.triPartyAgent + ", " +
				"collateralProfile=" + this.collateralProfile + ", " +
				"collateralType=" + this.collateralType +
			'}';
		}
	}
}
