package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LinkId;
import fpml.confirmation.validation.LinkIdTypeFormatValidator;
import fpml.confirmation.validation.LinkIdValidator;
import fpml.confirmation.validation.exists.LinkIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LinkId.class)
public class LinkIdMeta implements RosettaMetaData<LinkId> {

	@Override
	public List<Validator<? super LinkId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LinkId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LinkId> validator() {
		return new LinkIdValidator();
	}

	@Override
	public Validator<? super LinkId> typeFormatValidator() {
		return new LinkIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LinkId, Set<String>> onlyExistsValidator() {
		return new LinkIdOnlyExistsValidator();
	}
}
