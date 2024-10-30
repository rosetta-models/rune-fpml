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
import fpml.confirmation.EquityCorporateEvents;
import fpml.confirmation.EquityCorporateEvents.EquityCorporateEventsBuilder;
import fpml.confirmation.EquityCorporateEvents.EquityCorporateEventsBuilderImpl;
import fpml.confirmation.EquityCorporateEvents.EquityCorporateEventsImpl;
import fpml.confirmation.ShareExtraordinaryEventEnum;
import fpml.confirmation.meta.EquityCorporateEventsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the merger events and their treatment.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityCorporateEvents", builder=EquityCorporateEvents.EquityCorporateEventsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityCorporateEvents extends RosettaModelObject {

	EquityCorporateEventsMeta metaData = new EquityCorporateEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The consideration paid for the original shares following the Merger Event consists wholly of new shares.
	 */
	ShareExtraordinaryEventEnum getShareForShare();
	/**
	 * The consideration paid for the original shares following the Merger Event consists wholly of cash/securities other than new shares.
	 */
	ShareExtraordinaryEventEnum getShareForOther();
	/**
	 * The consideration paid for the original shares following the Merger Event consists of both cash/securities and new shares.
	 */
	ShareExtraordinaryEventEnum getShareForCombined();

	/*********************** Build Methods  ***********************/
	EquityCorporateEvents build();
	
	EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder();
	
	static EquityCorporateEvents.EquityCorporateEventsBuilder builder() {
		return new EquityCorporateEvents.EquityCorporateEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityCorporateEvents> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityCorporateEvents> getType() {
		return EquityCorporateEvents.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("shareForShare"), ShareExtraordinaryEventEnum.class, getShareForShare(), this);
		processor.processBasic(path.newSubPath("shareForOther"), ShareExtraordinaryEventEnum.class, getShareForOther(), this);
		processor.processBasic(path.newSubPath("shareForCombined"), ShareExtraordinaryEventEnum.class, getShareForCombined(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityCorporateEventsBuilder extends EquityCorporateEvents, RosettaModelObjectBuilder {
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForShare(ShareExtraordinaryEventEnum shareForShare);
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForOther(ShareExtraordinaryEventEnum shareForOther);
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForCombined(ShareExtraordinaryEventEnum shareForCombined);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("shareForShare"), ShareExtraordinaryEventEnum.class, getShareForShare(), this);
			processor.processBasic(path.newSubPath("shareForOther"), ShareExtraordinaryEventEnum.class, getShareForOther(), this);
			processor.processBasic(path.newSubPath("shareForCombined"), ShareExtraordinaryEventEnum.class, getShareForCombined(), this);
		}
		

		EquityCorporateEvents.EquityCorporateEventsBuilder prune();
	}

	/*********************** Immutable Implementation of EquityCorporateEvents  ***********************/
	class EquityCorporateEventsImpl implements EquityCorporateEvents {
		private final ShareExtraordinaryEventEnum shareForShare;
		private final ShareExtraordinaryEventEnum shareForOther;
		private final ShareExtraordinaryEventEnum shareForCombined;
		
		protected EquityCorporateEventsImpl(EquityCorporateEvents.EquityCorporateEventsBuilder builder) {
			this.shareForShare = builder.getShareForShare();
			this.shareForOther = builder.getShareForOther();
			this.shareForCombined = builder.getShareForCombined();
		}
		
		@Override
		@RosettaAttribute("shareForShare")
		public ShareExtraordinaryEventEnum getShareForShare() {
			return shareForShare;
		}
		
		@Override
		@RosettaAttribute("shareForOther")
		public ShareExtraordinaryEventEnum getShareForOther() {
			return shareForOther;
		}
		
		@Override
		@RosettaAttribute("shareForCombined")
		public ShareExtraordinaryEventEnum getShareForCombined() {
			return shareForCombined;
		}
		
		@Override
		public EquityCorporateEvents build() {
			return this;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder() {
			EquityCorporateEvents.EquityCorporateEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityCorporateEvents.EquityCorporateEventsBuilder builder) {
			ofNullable(getShareForShare()).ifPresent(builder::setShareForShare);
			ofNullable(getShareForOther()).ifPresent(builder::setShareForOther);
			ofNullable(getShareForCombined()).ifPresent(builder::setShareForCombined);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityCorporateEvents _that = getType().cast(o);
		
			if (!Objects.equals(shareForShare, _that.getShareForShare())) return false;
			if (!Objects.equals(shareForOther, _that.getShareForOther())) return false;
			if (!Objects.equals(shareForCombined, _that.getShareForCombined())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (shareForShare != null ? shareForShare.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForOther != null ? shareForOther.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForCombined != null ? shareForCombined.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityCorporateEvents {" +
				"shareForShare=" + this.shareForShare + ", " +
				"shareForOther=" + this.shareForOther + ", " +
				"shareForCombined=" + this.shareForCombined +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityCorporateEvents  ***********************/
	class EquityCorporateEventsBuilderImpl implements EquityCorporateEvents.EquityCorporateEventsBuilder {
	
		protected ShareExtraordinaryEventEnum shareForShare;
		protected ShareExtraordinaryEventEnum shareForOther;
		protected ShareExtraordinaryEventEnum shareForCombined;
	
		public EquityCorporateEventsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("shareForShare")
		public ShareExtraordinaryEventEnum getShareForShare() {
			return shareForShare;
		}
		
		@Override
		@RosettaAttribute("shareForOther")
		public ShareExtraordinaryEventEnum getShareForOther() {
			return shareForOther;
		}
		
		@Override
		@RosettaAttribute("shareForCombined")
		public ShareExtraordinaryEventEnum getShareForCombined() {
			return shareForCombined;
		}
		
		@Override
		@RosettaAttribute("shareForShare")
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForShare(ShareExtraordinaryEventEnum shareForShare) {
			this.shareForShare = shareForShare==null?null:shareForShare;
			return this;
		}
		@Override
		@RosettaAttribute("shareForOther")
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForOther(ShareExtraordinaryEventEnum shareForOther) {
			this.shareForOther = shareForOther==null?null:shareForOther;
			return this;
		}
		@Override
		@RosettaAttribute("shareForCombined")
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForCombined(ShareExtraordinaryEventEnum shareForCombined) {
			this.shareForCombined = shareForCombined==null?null:shareForCombined;
			return this;
		}
		
		@Override
		public EquityCorporateEvents build() {
			return new EquityCorporateEvents.EquityCorporateEventsImpl(this);
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getShareForShare()!=null) return true;
			if (getShareForOther()!=null) return true;
			if (getShareForCombined()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityCorporateEvents.EquityCorporateEventsBuilder o = (EquityCorporateEvents.EquityCorporateEventsBuilder) other;
			
			
			merger.mergeBasic(getShareForShare(), o.getShareForShare(), this::setShareForShare);
			merger.mergeBasic(getShareForOther(), o.getShareForOther(), this::setShareForOther);
			merger.mergeBasic(getShareForCombined(), o.getShareForCombined(), this::setShareForCombined);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityCorporateEvents _that = getType().cast(o);
		
			if (!Objects.equals(shareForShare, _that.getShareForShare())) return false;
			if (!Objects.equals(shareForOther, _that.getShareForOther())) return false;
			if (!Objects.equals(shareForCombined, _that.getShareForCombined())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (shareForShare != null ? shareForShare.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForOther != null ? shareForOther.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForCombined != null ? shareForCombined.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityCorporateEventsBuilder {" +
				"shareForShare=" + this.shareForShare + ", " +
				"shareForOther=" + this.shareForOther + ", " +
				"shareForCombined=" + this.shareForCombined +
			'}';
		}
	}
}
