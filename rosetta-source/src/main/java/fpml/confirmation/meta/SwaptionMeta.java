package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Swaption;
import fpml.confirmation.validation.SwaptionTypeFormatValidator;
import fpml.confirmation.validation.SwaptionValidator;
import fpml.confirmation.validation.exists.SwaptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Swaption.class)
public class SwaptionMeta implements RosettaMetaData<Swaption> {

	@Override
	public List<Validator<? super Swaption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Swaption>create(fpml.confirmation.validation.datarule.SwaptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Swaption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Swaption> validator() {
		return new SwaptionValidator();
	}

	@Override
	public Validator<? super Swaption> typeFormatValidator() {
		return new SwaptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Swaption, Set<String>> onlyExistsValidator() {
		return new SwaptionOnlyExistsValidator();
	}
}
